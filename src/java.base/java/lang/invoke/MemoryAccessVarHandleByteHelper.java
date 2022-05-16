/*
 * Copyright (c) 2019, Oracle and/or its affiliates. All rights reserved.
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
 *
 *
 */
package java.lang.invoke;

import jdk.internal.access.foreign.MemorySegmentProxy;
import jdk.internal.misc.ScopedMemoryAccess;
import jdk.internal.vm.annotation.ForceInline;

import java.lang.ref.Reference;

import java.util.Objects;

import static java.lang.invoke.MethodHandleStatics.UNSAFE;

// -- This file was mechanically generated: Do not edit! -- //

final class MemoryAccessVarHandleByteHelper extends MemoryAccessVarHandleBase {

    static final boolean BE = UNSAFE.isBigEndian();

    static final ScopedMemoryAccess SCOPED_MEMORY_ACCESS = ScopedMemoryAccess.getScopedMemoryAccess();

    static final int VM_ALIGN = Byte.BYTES - 1;

    static final VarForm FORM = new VarForm(MemoryAccessVarHandleByteHelper.class, MemorySegmentProxy.class, byte.class, long.class);

    MemoryAccessVarHandleByteHelper(boolean skipAlignmentMaskCheck, boolean be, long length, long alignmentMask, boolean exact) {
        super(FORM, skipAlignmentMaskCheck, be, length, alignmentMask, exact);
    }

    @Override
    final MethodType accessModeTypeUncached(VarHandle.AccessType accessType) {
        return accessType.accessModeType(MemorySegmentProxy.class, byte.class, long.class);
    }

    @Override
    public MemoryAccessVarHandleByteHelper withInvokeExactBehavior() {
        return hasInvokeExactBehavior() ?
                this :
                new MemoryAccessVarHandleByteHelper(skipAlignmentMaskCheck, be, length, alignmentMask, true);
    }

    @Override
    public MemoryAccessVarHandleByteHelper withInvokeBehavior() {
        return !hasInvokeExactBehavior() ?
                this :
                new MemoryAccessVarHandleByteHelper(skipAlignmentMaskCheck, be, length, alignmentMask, false);
    }

    @ForceInline
    static byte convEndian(boolean big, byte n) {
        return n;
    }

    @ForceInline
    static MemorySegmentProxy checkAddress(Object obb, long offset, long length, boolean ro) {
        MemorySegmentProxy oo = (MemorySegmentProxy)Objects.requireNonNull(obb);
        oo.checkAccess(offset, length, ro);
        return oo;
    }

    @ForceInline
    static long offset(boolean skipAlignmentMaskCheck, MemorySegmentProxy bb, long offset, long alignmentMask) {
        long address = offsetNoVMAlignCheck(skipAlignmentMaskCheck, bb, offset, alignmentMask);
        if ((address & VM_ALIGN) != 0) {
            throw MemoryAccessVarHandleBase.newIllegalStateExceptionForMisalignedAccess(address);
        }
        return address;
    }

    @ForceInline
    static long offsetNoVMAlignCheck(boolean skipAlignmentMaskCheck, MemorySegmentProxy bb, long offset, long alignmentMask) {
        long base = bb.unsafeGetOffset();
        long address = base + offset;
        if (skipAlignmentMaskCheck) {
            //note: the offset portion has already been aligned-checked, by construction
            if ((base & alignmentMask) != 0) {
                throw MemoryAccessVarHandleBase.newIllegalStateExceptionForMisalignedAccess(address);
            }
        } else {
            if ((address & alignmentMask) != 0) {
                throw MemoryAccessVarHandleBase.newIllegalStateExceptionForMisalignedAccess(address);
            }
        }
        return address;
    }

    @ForceInline
    static byte get(VarHandle ob, Object obb, long base) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, true);
        return SCOPED_MEMORY_ACCESS.getByte(bb.scope(),
                bb.unsafeGetBase(),
                offsetNoVMAlignCheck(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask));
    }

    @ForceInline
    static void set(VarHandle ob, Object obb, long base, byte value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        SCOPED_MEMORY_ACCESS.putByte(bb.scope(),
                bb.unsafeGetBase(),
                offsetNoVMAlignCheck(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                value);
    }

    @ForceInline
    static byte getVolatile(VarHandle ob, Object obb, long base) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, true);
        return convEndian(handle.be,
                          SCOPED_MEMORY_ACCESS.getByteVolatile(bb.scope(),
                                  bb.unsafeGetBase(),
                                  offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask)));
    }

    @ForceInline
    static void setVolatile(VarHandle ob, Object obb, long base, byte value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        SCOPED_MEMORY_ACCESS.putByteVolatile(bb.scope(),
                bb.unsafeGetBase(),
                offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                convEndian(handle.be, value));
    }

    @ForceInline
    static byte getAcquire(VarHandle ob, Object obb, long base) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, true);
        return convEndian(handle.be,
                          SCOPED_MEMORY_ACCESS.getByteAcquire(bb.scope(),
                                  bb.unsafeGetBase(),
                                  offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask)));
    }

    @ForceInline
    static void setRelease(VarHandle ob, Object obb, long base, byte value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        SCOPED_MEMORY_ACCESS.putByteRelease(bb.scope(),
                bb.unsafeGetBase(),
                offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                convEndian(handle.be, value));
    }

    @ForceInline
    static byte getOpaque(VarHandle ob, Object obb, long base) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, true);
        return convEndian(handle.be,
                          SCOPED_MEMORY_ACCESS.getByteOpaque(bb.scope(),
                                  bb.unsafeGetBase(),
                                  offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask)));
    }

    @ForceInline
    static void setOpaque(VarHandle ob, Object obb, long base, byte value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        SCOPED_MEMORY_ACCESS.putByteOpaque(bb.scope(),
                bb.unsafeGetBase(),
                offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                convEndian(handle.be, value));
    }
}
