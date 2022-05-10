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

package jdk.internal.reflect;

import jdk.internal.vm.annotation.ForceInline;
import jdk.internal.vm.annotation.Hidden;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.WrongMethodTypeException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static jdk.internal.reflect.MethodHandleAccessorFactory.SPECIALIZED_PARAM_COUNT;

class DirectConstructorHandleAccessor extends ConstructorAccessorImpl {
    static ConstructorAccessorImpl constructorAccessor(Constructor<?> ctor, MethodHandle target) {
        return new DirectConstructorHandleAccessor(ctor, target);
    }

    static ConstructorAccessorImpl nativeAccessor(Constructor<?> ctor) {
        return new NativeAccessor(ctor);
    }

    private static final int PARAM_COUNT_MASK = 0x00FF;
    private static final int NONZERO_BIT = 0x8000_0000;

    private final int paramFlags;
    private final MethodHandle target;

    DirectConstructorHandleAccessor(Constructor<?> ctor, MethodHandle target) {
        this.paramFlags = (ctor.getParameterCount() & PARAM_COUNT_MASK) | NONZERO_BIT;
        this.target = target;
    }

    @Override
    public Object newInstance(Object[] args) throws InstantiationException, InvocationTargetException {
        int argc = args != null ? args.length : 0;
        // only check argument count for specialized forms
        int paramCount = paramFlags & PARAM_COUNT_MASK;
        if (paramCount <= SPECIALIZED_PARAM_COUNT && argc != paramCount) {
            throw new IllegalArgumentException("wrong number of arguments: " + argc + " expected: " + paramCount);
        }
        try {
            return invokeImpl(args);
        } catch (ClassCastException|WrongMethodTypeException e) {
            if (isIllegalArgument(e))
                throw new IllegalArgumentException("argument type mismatch", e);
            else
                throw new InvocationTargetException(e);
        } catch (NullPointerException e) {
            if (isIllegalArgument(e))
                throw new IllegalArgumentException(e);
            else
                throw new InvocationTargetException(e);
        } catch (Throwable e) {
            throw new InvocationTargetException(e);
        }
    }

    private boolean isIllegalArgument(RuntimeException ex) {
        return AccessorUtils.isIllegalArgument(DirectConstructorHandleAccessor.class, ex);
    }

    @Hidden
    @ForceInline
    Object invokeImpl(Object[] args) throws Throwable {
        return switch (paramFlags & PARAM_COUNT_MASK) {
            case 0 -> target.invokeExact();
            case 1 -> target.invokeExact(args[0]);
            case 2 -> target.invokeExact(args[0], args[1]);
            case 3 -> target.invokeExact(args[0], args[1], args[2]);
            default -> target.invokeExact(args);
        };
    }

    /**
     * Invoke the constructor via native VM reflection
     */
    static class NativeAccessor extends ConstructorAccessorImpl {
        private final Constructor<?> ctor;
        NativeAccessor(Constructor<?> ctor) {
            this.ctor = ctor;
        }

        @Override
        public Object newInstance(Object[] args) throws InstantiationException, InvocationTargetException {
            return newInstance0(ctor, args);
        }
        private static native Object newInstance0(Constructor<?> c, Object[] args)
                    throws InstantiationException, InvocationTargetException;
    }
}
