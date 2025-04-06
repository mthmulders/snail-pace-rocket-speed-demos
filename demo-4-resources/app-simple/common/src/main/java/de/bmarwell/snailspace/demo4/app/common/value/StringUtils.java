package de.bmarwell.snailspace.demo4.app.common.value;

public class StringUtils {

    public static boolean isNullOrEmpty(final String str) {
        return str == null || str.trim().isEmpty();
    }

}
