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

package jdk.tools.jlink.internal.plugins;

import jdk.tools.jlink.plugin.Plugin;
import jdk.tools.jlink.internal.JlinkTask;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import jdk.internal.org.objectweb.asm.ClassReader;

public abstract class AbstractPlugin implements Plugin {

    static final String DESCRIPTION = "description";
    static final String USAGE = "usage";

    private static final ResourceBundle standardPluginsBundle;

    static {
        Locale locale = Locale.getDefault();
        try {
            standardPluginsBundle = ResourceBundle.getBundle("jdk.tools.jlink."
                    + "resources.plugins", locale);
        } catch (MissingResourceException e) {
            throw new InternalError("Cannot find jlink resource bundle for "
                    + "locale " + locale);
        }
    }

    private final ResourceBundle pluginsBundle;
    private final String name;

    protected AbstractPlugin(String name) {
        this.name = name;
        this.pluginsBundle = standardPluginsBundle;
    }

    protected AbstractPlugin(String name, ResourceBundle bundle) {
        this.name = name;
        this.pluginsBundle = bundle;
    }

    private void dumpClassFile(String path, byte[] buf) {
        try {
            String fullPath = String.format("%d-%s%s%s",
                 ProcessHandle.current().pid(),
                 getName(), File.separator,
                 path.replace('/', File.separatorChar));
            System.err.printf("Dumping class file %s\n", fullPath);
            new File(fullPath.substring(0, fullPath.lastIndexOf('/'))).mkdirs();
            Files.write(Paths.get(fullPath), buf);
        } catch (IOException ioExp) {
            System.err.println("writing " + path + " failed");
            ioExp.printStackTrace();
        }
    }

    protected ClassReader newClassReader(String path, byte[] buf) {
        try {
            return new ClassReader(buf);
        } catch (IllegalArgumentException iae) {
            if (JlinkTask.DEBUG) {
                System.err.printf("Failed to parse class file: %s\n", path);
                iae.printStackTrace();
                dumpClassFile(path, buf);
            }
            throw iae;
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return getMessage(getName() + "." + DESCRIPTION, getName());
    }

    @Override
    public String getUsage() {
        return getMessage(getName() + "." + USAGE, getName());
    }

    @Override
    public String getArgumentsDescription() {
        return PluginsResourceBundle.getArgument(getName());
    }

    protected String getMessage(String key, Object...args) {
       return PluginsResourceBundle.getMessage(this.pluginsBundle, key, args);
    }
}
