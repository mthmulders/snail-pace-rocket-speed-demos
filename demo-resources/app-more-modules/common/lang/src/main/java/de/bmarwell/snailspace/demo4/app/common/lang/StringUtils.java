package de.bmarwell.snailspace.demo4.app.common.lang;

public class StringUtils {

    public static boolean isNullOrEmpty(final String str) {
        return str == null || str.trim().isEmpty();
    }

}
