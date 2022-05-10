/*
 * Copyright (c) 2021, Oracle and/or its affiliates. All rights reserved.
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

package jdk.internal.foreign;

import jdk.incubator.foreign.MemorySegment;
import jdk.incubator.foreign.SegmentAllocator;
import jdk.incubator.foreign.ResourceScope;

public final class ArenaAllocator implements SegmentAllocator {

    public static final long DEFAULT_BLOCK_SIZE = 4 * 1024;

    private MemorySegment segment;

    private long sp = 0L;
    private long size = 0;
    private final long blockSize;
    private final long arenaSize;
    private final ResourceScope scope;

    public ArenaAllocator(long blockSize, long arenaSize, ResourceScope scope) {
        this.blockSize = blockSize;
        this.arenaSize = arenaSize;
        this.scope = scope;
        this.segment = newSegment(blockSize, 1);
    }

    MemorySegment trySlice(long bytesSize, long bytesAlignment) {
        long min = segment.address().toRawLongValue();
        long start = Utils.alignUp(min + sp, bytesAlignment) - min;
        if (segment.byteSize() - start < bytesSize) {
            return null;
        } else {
            MemorySegment slice = segment.asSlice(start, bytesSize);
            sp = start + bytesSize;
            return slice;
        }
    }

    public ResourceScope scope() {
        return scope;
    }

    private MemorySegment newSegment(long bytesSize, long bytesAlignment) {
        long allocatedSize = Utils.alignUp(bytesSize, bytesAlignment);
        if (size + allocatedSize > arenaSize) {
            throw new OutOfMemoryError();
        }
        size += allocatedSize;
        return MemorySegment.allocateNative(bytesSize, bytesAlignment, scope);
    }

    @Override
    public MemorySegment allocate(long bytesSize, long bytesAlignment) {
        // try to slice from current segment first...
        MemorySegment slice = trySlice(bytesSize, bytesAlignment);
        if (slice != null) {
            return slice;
        } else {
            long maxPossibleAllocationSize = bytesSize + bytesAlignment - 1;
            if (maxPossibleAllocationSize > blockSize) {
                // too big
                return newSegment(bytesSize, bytesAlignment);
            } else {
                // allocate a new segment and slice from there
                sp = 0L;
                segment = newSegment(blockSize, 1L);
                slice = trySlice(bytesSize, bytesAlignment);
                return slice;
            }
        }
    }
}
