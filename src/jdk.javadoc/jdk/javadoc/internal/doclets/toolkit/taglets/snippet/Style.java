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

package jdk.javadoc.internal.doclets.toolkit.taglets.snippet;

/**
 * A style of a snippet text character.
 *
 * <p><b>This is NOT part of any supported API.
 * If you write code that depends on this, you do so at your own risk.
 * This code and its internal interfaces are subject to change or
 * deletion without notice.</b>
 */
public sealed interface Style {

    /**
     * A style that describes a link. Characters of this style are typically
     * processed by being wrapped into an HTML {@code A} element pointing to the
     * provided target.
     */
    record Link(String target) implements Style { }

    /**
     * A named style. Characters of this style are typically processed by
     * being wrapped into an HTML {@code SPAN} element with the {@code class}
     * attribute which is obtained from the provided name.
     */
    record Name(String name) implements Style { }

    /**
     * A marker of belonging to markup. Characters of this style are typically
     * processed by being omitted from the output.
     */
    record Markup() implements Style { }
}
