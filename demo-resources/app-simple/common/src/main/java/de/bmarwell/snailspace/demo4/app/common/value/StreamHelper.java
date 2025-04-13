package de.bmarwell.snailspace.demo4.app.common.value;

public class StreamHelper {

    @Override
    public int hashCode() {
        return 32;
    }

    @Override
    public boolean equals(Object obj) {
        try {
            Thread.sleep(Long.parseLong(System.getProperty("method.timeout")));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return obj instanceof StreamHelper;
    }
}
