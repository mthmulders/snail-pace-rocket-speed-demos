package de.bmarwell.snailspace.demo4.app.common.value;

public class StringUtils {

    public static boolean isNullOrEmpty(final String str) {
        try {
            Thread.sleep(Long.parseLong(System.getProperty("method.timeout")));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return str == null || str.trim().isEmpty();
    }

}
