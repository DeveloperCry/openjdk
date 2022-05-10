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

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Convenient access to attributes.
 *
 * <p><b>This is NOT part of any supported API.
 * If you write code that depends on this, you do so at your own risk.
 * This code and its internal interfaces are subject to change or
 * deletion without notice.</b>
 */
public final class Attributes {

    private final Map<String, List<Attribute>> attributes;

    public Attributes(Collection<? extends Attribute> attributes) {
        this.attributes = attributes
                .stream()
                .collect(Collectors.groupingBy(Attribute::name,
                                               Collectors.toList()));
    }

    /*
     * 1. If there are multiple attributes with the same name and type, it is
     * unknown which one of these attributes will be returned.
     *
     * 2. If there are no attributes with this name and type, an empty optional
     * will be returned.
     *
     * 3. If a non-specific (any/or/union/etc.) result is required, query for
     * the Attribute.class type.
     */
    public <T extends Attribute> Optional<T> get(String name, Class<T> type) {
        return attributes.getOrDefault(name, List.of())
                .stream()
                .filter(type::isInstance)
                .map(type::cast)
                .findAny();
    }
}
