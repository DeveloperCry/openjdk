/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */


package org.graalvm.compiler.hotspot.aarch64;

import static jdk.vm.ci.code.ValueUtil.asRegister;

import java.util.ArrayList;
import java.util.EnumSet;

import jdk.vm.ci.code.CallingConvention;
import jdk.vm.ci.meta.AllocatableValue;
import jdk.vm.ci.meta.Constant;
import jdk.vm.ci.meta.Value;

import org.graalvm.compiler.asm.aarch64.AArch64MacroAssembler;
import org.graalvm.compiler.core.common.spi.ForeignCallLinkage;
import org.graalvm.compiler.lir.LIRFrameState;
import org.graalvm.compiler.lir.LIRInstructionClass;
import org.graalvm.compiler.lir.LIRValueUtil;
import org.graalvm.compiler.lir.ValueProcedure;
import org.graalvm.compiler.lir.aarch64.AArch64LIRInstruction;
import org.graalvm.compiler.lir.asm.CompilationResultBuilder;

public final class AArch64HotSpotConstantRetrievalOp extends AArch64LIRInstruction {
    public static final LIRInstructionClass<AArch64HotSpotConstantRetrievalOp> TYPE = LIRInstructionClass.create(AArch64HotSpotConstantRetrievalOp.class);

    @Def protected AllocatableValue result;
    protected final Constant[] constants;
    @Alive protected AllocatableValue[] constantDescriptions;
    @Temp protected AllocatableValue[] gotSlotOffsetParameters;
    @Temp protected AllocatableValue[] descriptionParameters;
    @Temp protected Value[] callTemps;
    @State protected LIRFrameState frameState;
    private final ForeignCallLinkage callLinkage;
    private final Object[] notes;

    private class CollectTemporaries implements ValueProcedure {
        ArrayList<Value> values = new ArrayList<>();

        CollectTemporaries() {
            forEachTemp(this);
        }

        public Value[] asArray() {
            Value[] copy = new Value[values.size()];
            return values.toArray(copy);
        }

        @Override
        public Value doValue(Value value, OperandMode mode, EnumSet<OperandFlag> flags) {
            values.add(value);
            return value;
        }
    }

    public AArch64HotSpotConstantRetrievalOp(Constant[] constants, AllocatableValue[] constantDescriptions, LIRFrameState frameState, ForeignCallLinkage callLinkage, Object[] notes) {
        super(TYPE);
        this.constantDescriptions = constantDescriptions;
        this.constants = constants;
        this.frameState = frameState;
        this.notes = notes;
        assert constants.length == notes.length;

        // call arguments
        CallingConvention callingConvention = callLinkage.getOutgoingCallingConvention();
        this.gotSlotOffsetParameters = new AllocatableValue[constants.length];
        int argIndex = 0;
        for (int i = 0; i < constants.length; i++, argIndex++) {
            this.gotSlotOffsetParameters[i] = callingConvention.getArgument(argIndex);
        }
        this.descriptionParameters = new AllocatableValue[constantDescriptions.length];
        for (int i = 0; i < constantDescriptions.length; i++, argIndex++) {
            this.descriptionParameters[i] = callingConvention.getArgument(argIndex);
        }
        this.result = callingConvention.getReturn();

        this.callLinkage = callLinkage;

        // compute registers that are killed by the stub, but are not used as other temps.
        this.callTemps = new Value[0];
        this.callTemps = LIRValueUtil.subtractRegisters(callLinkage.getTemporaries(), new CollectTemporaries().asArray());
    }

    @Override
    public void emitCode(CompilationResultBuilder crb, AArch64MacroAssembler masm) {
        // metadata_adr
        for (int i = 0; i < constants.length; i++) {
            crb.recordInlineDataInCodeWithNote(constants[i], notes[i]);
            masm.addressOf(asRegister(gotSlotOffsetParameters[i]));
        }

        for (int i = 0; i < constantDescriptions.length; i++) {
            masm.mov(64, asRegister(descriptionParameters[i]), asRegister(constantDescriptions[i]));
        }

        final int before = masm.position();
        masm.bl(before);
        final int after = masm.position();
        crb.recordDirectCall(before, after, callLinkage, frameState);
    }

}
