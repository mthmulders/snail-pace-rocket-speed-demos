package de.bmarwell.snailspace.demo4.app.common.lang;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamHelper {

    public static void copyTo(InputStream inputStream, OutputStream outputStream) throws IOException {
        try {
            Thread.sleep(Long.parseLong(System.getProperty("method.timeout", "100")));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        byte[] buffer = new byte[512];
        int read;

        while ((read = inputStream.read(buffer)) > 0) {
            outputStream.write(buffer, 0, read);
        }
    }

    @Override
    public int hashCode() {
        return 32;
    }

    @Override
    public boolean equals(Object obj) {
        try {
            Thread.sleep(Long.parseLong(System.getProperty("method.timeout", "100")));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return obj instanceof StreamHelper;
    }
}
