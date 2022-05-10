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

package sun.nio.ch;

import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.channels.spi.*;
import java.util.Objects;

/**
 * This class is defined here rather than in java.nio.channels.Channels
 * so that it will be accessible from java.nio.channels.Channels and
 * sun.nio.ch.ChannelInputStream.
 *
 *
 * @author Mark Reinhold
 * @author Mike McCloskey
 * @author JSR-51 Expert Group
 * @since 18
 */
public class ChannelOutputStream extends OutputStream {

    private final WritableByteChannel ch;
    private ByteBuffer bb;
    private byte[] bs;       // Invoker's previous array
    private byte[] b1;

    /**
     * Write all remaining bytes in buffer to the given channel.
     * If the channel is selectable then it must be configured blocking.
     */
    private static void writeFullyImpl(WritableByteChannel ch, ByteBuffer bb)
        throws IOException
    {
        while (bb.remaining() > 0) {
            int n = ch.write(bb);
            if (n <= 0)
                throw new RuntimeException("no bytes written");
        }
    }

    /**
     * Write all remaining bytes in buffer to the given channel.
     *
     * @throws  IllegalBlockingModeException
     *          If the channel is selectable and configured non-blocking.
     */
    private static void writeFully(WritableByteChannel ch, ByteBuffer bb)
        throws IOException
    {
        if (ch instanceof SelectableChannel sc) {
            synchronized (sc.blockingLock()) {
                if (!sc.isBlocking())
                    throw new IllegalBlockingModeException();
                writeFullyImpl(ch, bb);
            }
        } else {
            writeFullyImpl(ch, bb);
        }
    }

    /**
     * @param ch The channel wrapped by this stream.
     */
    public ChannelOutputStream(WritableByteChannel ch) {
        this.ch = ch;
    }

    /**
     * @return The channel wrapped by this stream.
     */
    WritableByteChannel channel() {
        return ch;
    }

    @Override
    public synchronized void write(int b) throws IOException {
        if (b1 == null)
            b1 = new byte[1];
        b1[0] = (byte) b;
        this.write(b1);
    }

    @Override
    public synchronized void write(byte[] bs, int off, int len)
        throws IOException {
        Objects.checkFromIndexSize(off, len, bs.length);
        if (len == 0) {
            return;
        }
        ByteBuffer bb = ((this.bs == bs)
                         ? this.bb
                         : ByteBuffer.wrap(bs));
        bb.limit(Math.min(off + len, bb.capacity()));
        bb.position(off);
        this.bb = bb;
        this.bs = bs;
        writeFully(ch, bb);
    }

    @Override
    public void close() throws IOException {
        ch.close();
    }

}
