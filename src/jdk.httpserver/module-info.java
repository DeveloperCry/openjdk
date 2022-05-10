/*
 * Copyright (c) 2014, 2021, Oracle and/or its affiliates. All rights reserved.
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

/**
 * Defines the JDK-specific HTTP server API, and provides the jwebserver tool
 * for running a minimal HTTP server.
 *
 * <p>The {@link com.sun.net.httpserver} package defines a high-level API for
 * building servers that support HTTP and HTTPS. The SimpleFileServer class
 * implements a simple HTTP-only file server intended for testing, development
 * and debugging purposes. A default implementation is provided via the
 * {@code jwebserver} tool and the main entry point of the module, which can
 * also be invoked with {@code java -m jdk.httpserver}.
 *
 * <p>The {@link com.sun.net.httpserver.spi} package specifies a Service Provider
 * Interface (SPI) for locating HTTP server implementations based on the
 * {@code com.sun.net.httpserver} API.
 *
 * @toolGuide jwebserver
 *
 * @uses com.sun.net.httpserver.spi.HttpServerProvider
 *
 * @moduleGraph
 * @since 9
 */
module jdk.httpserver {

    exports com.sun.net.httpserver;
    exports com.sun.net.httpserver.spi;

    uses com.sun.net.httpserver.spi.HttpServerProvider;
}
