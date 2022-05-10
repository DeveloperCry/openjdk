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
package jdk.management.jfr;

import java.io.IOException;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import jdk.jfr.internal.management.ManagementSupport;

final class DownLoadThread extends Thread {
    private final RemoteRecordingStream stream;
    private final Instant startTime;
    private final Instant endTime;
    private final DiskRepository diskRepository;

    DownLoadThread(RemoteRecordingStream stream, String name) {
        super(name);
        this.stream = stream;
        this.startTime = stream.startTime;
        this.endTime = stream.endTime;
        this.diskRepository = stream.repository;
    }

    public void run() {
        try {
            Map<String, String> options = new HashMap<>();
            if (startTime != null) {
                options.put("startTime", startTime.toString());
            }
            if (endTime != null) {
                options.put("endTime", endTime.toString());
            }
            options.put("streamVersion", "1.0");
            long streamId = this.stream.mbean.openStream(stream.recordingId, options);
            while (!stream.isClosed()) {
                byte[] bytes = stream.mbean.readStream(streamId);
                if (bytes == null) {
                    return;
                }
                if (bytes.length != 0) {
                    diskRepository.write(bytes);
                } else {
                    takeNap();
                }
            }
        } catch (IOException ioe) {
            ManagementSupport.logDebug(ioe.getMessage());
        } finally {
           diskRepository.complete();
        }
    }

    private void takeNap() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ie) {
            // ignore
        }
    }
}
