package de.bmarwell.snailspace.demo4.app.common.value;

public record UserId(String value) {

    public UserId {
        try {
            Thread.sleep(Long.parseLong(System.getProperty("method.timeout")));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
