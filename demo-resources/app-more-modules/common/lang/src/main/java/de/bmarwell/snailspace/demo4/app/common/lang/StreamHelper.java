package de.bmarwell.snailspace.demo4.app.common.lang;

public class StreamHelper {

    @Override
    public int hashCode() {
        return 32;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof StreamHelper;
    }
}
