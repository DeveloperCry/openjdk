/*
 * Copyright (c) 2018, 2021, Oracle and/or its affiliates. All rights reserved.
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
 */

package sun.jvm.hotspot.gc.z;

import java.util.ArrayList;
import java.util.List;

import sun.jvm.hotspot.debugger.Address;
import sun.jvm.hotspot.debugger.OopHandle;
import sun.jvm.hotspot.gc.shared.LiveRegionsProvider;
import sun.jvm.hotspot.memory.MemRegion;
import sun.jvm.hotspot.oops.Oop;
import sun.jvm.hotspot.oops.UnknownOopException;
import sun.jvm.hotspot.runtime.VM;
import sun.jvm.hotspot.runtime.VMObject;
import sun.jvm.hotspot.runtime.VMObjectFactory;
import sun.jvm.hotspot.types.AddressField;
import sun.jvm.hotspot.types.CIntegerField;
import sun.jvm.hotspot.types.Type;
import sun.jvm.hotspot.types.TypeDataBase;

public class ZPage extends VMObject implements LiveRegionsProvider {
    private static CIntegerField typeField;
    private static CIntegerField seqnumField;
    private static long virtualFieldOffset;
    private static AddressField topField;

    static {
        VM.registerVMInitializedObserver((o, d) -> initialize(VM.getVM().getTypeDataBase()));
    }

    private static synchronized void initialize(TypeDataBase db) {
        Type type = db.lookupType("ZPage");

        typeField = type.getCIntegerField("_type");
        seqnumField = type.getCIntegerField("_seqnum");
        virtualFieldOffset = type.getField("_virtual").getOffset();
        topField = type.getAddressField("_top");
    }

    public ZPage(Address addr) {
        super(addr);
    }

    private byte type() {
        return typeField.getJByte(addr);
    }

    private int seqnum() {
        return seqnumField.getJInt(addr);
    }

    private ZVirtualMemory virtual() {
        return VMObjectFactory.newObject(ZVirtualMemory.class, addr.addOffsetTo(virtualFieldOffset));
    }

    private Address top() {
        return topField.getValue(addr);
    }

    private boolean is_relocatable() {
        return seqnum() < ZGlobals.ZGlobalSeqNum();
    }

    long start() {
        return virtual().start();
    }

    long size() {
        return virtual().end() - virtual().start();
    }

    long object_alignment_shift() {
        if (type() == ZGlobals.ZPageTypeSmall) {
            return ZGlobals.ZObjectAlignmentSmallShift();
        } else if (type() == ZGlobals.ZPageTypeMedium) {
            return ZGlobals.ZObjectAlignmentMediumShift;
        } else {
            assert(type() == ZGlobals.ZPageTypeLarge);
            return ZGlobals.ZObjectAlignmentLargeShift;
        }
    }

    long objectAlignmentSize() {
        return 1 << object_alignment_shift();
    }

    public boolean isIn(Address addr) {
        long offset = ZAddress.offset(addr);
        // FIXME: it does not consider the sign.
        return (offset >= start()) && (offset < top().asLongValue());
    }

    private long getObjectSize(Address good) {
        OopHandle handle = good.addOffsetToAsOopHandle(0);
        Oop obj = null;

        try {
           obj = VM.getVM().getObjectHeap().newOop(handle);
        } catch (UnknownOopException exp) {
          throw new RuntimeException(" UnknownOopException  " + exp);
        }

        return VM.getVM().alignUp(obj.getObjectSize(), objectAlignmentSize());
    }

    public List<MemRegion> getLiveRegions() {
        Address start = ZAddress.good(ZUtils.longToAddress(start()));

        // Can't convert top() to a "good" address because it might
        // be at the top of the "offset" range, and therefore also
        // looks like one of the color bits. Instead use the "good"
        // address and add the size.
        long size = top().asLongValue() - start();
        Address end = start.addOffsetTo(size);

        return List.of(new MemRegion(start, end));
    }
}
