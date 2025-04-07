package de.bmarwell.snailspace.demo4.app.common.value;

public record User(UserId userId, String name) {

    public User {
        try {
            Thread.sleep(Long.parseLong(System.getProperty("method.timeout")));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
