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

final class MemoryAccessVarHandleShortHelper extends MemoryAccessVarHandleBase {

    static final boolean BE = UNSAFE.isBigEndian();

    static final ScopedMemoryAccess SCOPED_MEMORY_ACCESS = ScopedMemoryAccess.getScopedMemoryAccess();

    static final int VM_ALIGN = Short.BYTES - 1;

    static final VarForm FORM = new VarForm(MemoryAccessVarHandleShortHelper.class, MemorySegmentProxy.class, short.class, long.class);

    MemoryAccessVarHandleShortHelper(boolean skipAlignmentMaskCheck, boolean be, long length, long alignmentMask, boolean exact) {
        super(FORM, skipAlignmentMaskCheck, be, length, alignmentMask, exact);
    }

    @Override
    final MethodType accessModeTypeUncached(VarHandle.AccessType accessType) {
        return accessType.accessModeType(MemorySegmentProxy.class, short.class, long.class);
    }

    @Override
    public MemoryAccessVarHandleShortHelper withInvokeExactBehavior() {
        return hasInvokeExactBehavior() ?
                this :
                new MemoryAccessVarHandleShortHelper(skipAlignmentMaskCheck, be, length, alignmentMask, true);
    }

    @Override
    public MemoryAccessVarHandleShortHelper withInvokeBehavior() {
        return !hasInvokeExactBehavior() ?
                this :
                new MemoryAccessVarHandleShortHelper(skipAlignmentMaskCheck, be, length, alignmentMask, false);
    }

    @ForceInline
    static short convEndian(boolean big, short n) {
        return big == BE ? n : Short.reverseBytes(n);
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
    static short get(VarHandle ob, Object obb, long base) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, true);
        return SCOPED_MEMORY_ACCESS.getShortUnaligned(bb.scope(),
                bb.unsafeGetBase(),
                offsetNoVMAlignCheck(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                handle.be);
    }

    @ForceInline
    static void set(VarHandle ob, Object obb, long base, short value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        SCOPED_MEMORY_ACCESS.putShortUnaligned(bb.scope(),
                bb.unsafeGetBase(),
                offsetNoVMAlignCheck(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                value,
                handle.be);
    }

    @ForceInline
    static short getVolatile(VarHandle ob, Object obb, long base) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, true);
        return convEndian(handle.be,
                          SCOPED_MEMORY_ACCESS.getShortVolatile(bb.scope(),
                                  bb.unsafeGetBase(),
                                  offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask)));
    }

    @ForceInline
    static void setVolatile(VarHandle ob, Object obb, long base, short value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        SCOPED_MEMORY_ACCESS.putShortVolatile(bb.scope(),
                bb.unsafeGetBase(),
                offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                convEndian(handle.be, value));
    }

    @ForceInline
    static short getAcquire(VarHandle ob, Object obb, long base) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, true);
        return convEndian(handle.be,
                          SCOPED_MEMORY_ACCESS.getShortAcquire(bb.scope(),
                                  bb.unsafeGetBase(),
                                  offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask)));
    }

    @ForceInline
    static void setRelease(VarHandle ob, Object obb, long base, short value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        SCOPED_MEMORY_ACCESS.putShortRelease(bb.scope(),
                bb.unsafeGetBase(),
                offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                convEndian(handle.be, value));
    }

    @ForceInline
    static short getOpaque(VarHandle ob, Object obb, long base) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, true);
        return convEndian(handle.be,
                          SCOPED_MEMORY_ACCESS.getShortOpaque(bb.scope(),
                                  bb.unsafeGetBase(),
                                  offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask)));
    }

    @ForceInline
    static void setOpaque(VarHandle ob, Object obb, long base, short value) {
        MemoryAccessVarHandleBase handle = (MemoryAccessVarHandleBase)ob;
        MemorySegmentProxy bb = checkAddress(obb, base, handle.length, false);
        SCOPED_MEMORY_ACCESS.putShortOpaque(bb.scope(),
                bb.unsafeGetBase(),
                offset(handle.skipAlignmentMaskCheck, bb, base, handle.alignmentMask),
                convEndian(handle.be, value));
    }
}
