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

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

class MethodHandleIntegerFieldAccessorImpl extends MethodHandleFieldAccessorImpl {
    static FieldAccessorImpl fieldAccessor(Field field, MethodHandle getter, MethodHandle setter, boolean isReadOnly) {
        boolean isStatic = Modifier.isStatic(field.getModifiers());
        if (isStatic) {
            getter = getter.asType(MethodType.methodType(int.class));
            if (setter != null) {
                setter = setter.asType(MethodType.methodType(void.class, int.class));
            }
        } else {
            getter = getter.asType(MethodType.methodType(int.class, Object.class));
            if (setter != null) {
                setter = setter.asType(MethodType.methodType(void.class, Object.class, int.class));
            }
        }
        return new MethodHandleIntegerFieldAccessorImpl(field, getter, setter, isReadOnly, isStatic);
    }

    MethodHandleIntegerFieldAccessorImpl(Field field, MethodHandle getter, MethodHandle setter, boolean isReadOnly, boolean isStatic) {
        super(field, getter, setter, isReadOnly, isStatic);
    }

    public Object get(Object obj) throws IllegalArgumentException {
        return Integer.valueOf(getInt(obj));
    }

    public boolean getBoolean(Object obj) throws IllegalArgumentException {
        throw newGetBooleanIllegalArgumentException();
    }

    public byte getByte(Object obj) throws IllegalArgumentException {
        throw newGetByteIllegalArgumentException();
    }

    public char getChar(Object obj) throws IllegalArgumentException {
        throw newGetCharIllegalArgumentException();
    }

    public short getShort(Object obj) throws IllegalArgumentException {
        throw newGetShortIllegalArgumentException();
    }

    public int getInt(Object obj) throws IllegalArgumentException {
        try {
            if (isStatic()) {
                return (int) getter.invokeExact();
            } else {
                return (int) getter.invokeExact(obj);
            }
        } catch (IllegalArgumentException|NullPointerException e) {
            throw e;
        } catch (ClassCastException e) {
            throw newGetIllegalArgumentException(obj);
        } catch (Throwable e) {
            throw new InternalError(e);
        }
    }

    public long getLong(Object obj) throws IllegalArgumentException {
        return getInt(obj);
    }

    public float getFloat(Object obj) throws IllegalArgumentException {
        return getInt(obj);
    }

    public double getDouble(Object obj) throws IllegalArgumentException {
        return getInt(obj);
    }

    public void set(Object obj, Object value)
            throws IllegalArgumentException, IllegalAccessException
    {
        ensureObj(obj);
        if (isReadOnly()) {
            throwFinalFieldIllegalAccessException(value);
        }

        if (value == null) {
            throwSetIllegalArgumentException(value);
        }

        if (value instanceof Byte b) {
            setInt(obj, b.byteValue());
        }
        else if (value instanceof Short s) {
            setInt(obj, s.shortValue());
        }
        else if (value instanceof Character c) {
            setInt(obj, c.charValue());
        }
        else if (value instanceof Integer i) {
            setInt(obj, i.intValue());
        }
        else {
            throwSetIllegalArgumentException(value);
        }
    }

    public void setBoolean(Object obj, boolean z)
        throws IllegalArgumentException, IllegalAccessException
    {
        throwSetIllegalArgumentException(z);
    }

    public void setByte(Object obj, byte b)
        throws IllegalArgumentException, IllegalAccessException
    {
        setInt(obj, b);
    }

    public void setChar(Object obj, char c)
        throws IllegalArgumentException, IllegalAccessException
    {
        setInt(obj, c);
    }

    public void setShort(Object obj, short s)
        throws IllegalArgumentException, IllegalAccessException
    {
        setInt(obj, s);
    }

    public void setInt(Object obj, int i)
        throws IllegalArgumentException, IllegalAccessException
    {
        if (isReadOnly()) {
            ensureObj(obj);     // throw NPE if obj is null on instance field
            throwFinalFieldIllegalAccessException(i);
        }
        try {
            if (isStatic()) {
                setter.invokeExact(i);
            } else {
                setter.invokeExact(obj, i);
            }
        } catch (IllegalArgumentException|NullPointerException e) {
            throw e;
        } catch (ClassCastException e) {
            // receiver is of invalid type
            throw newSetIllegalArgumentException(obj);
        } catch (Throwable e) {
            throw new InternalError(e);
        }
    }

    public void setLong(Object obj, long l)
        throws IllegalArgumentException, IllegalAccessException
    {
        throwSetIllegalArgumentException(l);
    }

    public void setFloat(Object obj, float f)
        throws IllegalArgumentException, IllegalAccessException
    {
        throwSetIllegalArgumentException(f);
    }

    public void setDouble(Object obj, double d)
        throws IllegalArgumentException, IllegalAccessException
    {
        throwSetIllegalArgumentException(d);
    }
}
