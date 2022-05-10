/*
 * Copyright (c) 2020, Oracle and/or its affiliates. All rights reserved.
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

package jdk.incubator.foreign;

/**
 * Represents a type which is <em>addressable</em>. An addressable type is one which can be projected down to
 * a {@linkplain #address() memory address}. Examples of addressable types are {@link MemorySegment},
 * {@link MemoryAddress}, {@link VaList} and {@link NativeSymbol}.
 * <p>
 * The {@link Addressable} type is used by the {@link CLinker C linker} to model the types of
 * {@link CLinker#downcallHandle(FunctionDescriptor) downcall handle} parameters that must be passed <em>by reference</em>
 * (e.g. memory addresses, va lists and upcall stubs).
 *
 * @implSpec
 * Implementations of this interface are <a href="{@docRoot}/java.base/java/lang/doc-files/ValueBased.html">value-based</a>.
 */
public sealed interface Addressable permits MemorySegment, MemoryAddress, NativeSymbol, VaList {

    /**
     * {@return the {@linkplain MemoryAddress memory address} associated with this addressable}
     */
    MemoryAddress address();
}
