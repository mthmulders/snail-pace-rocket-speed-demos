package de.bmarwell.snailspace.demo4.app.services.commands;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class DeleteUserCommandHandlerTest {

    @Test
    void test() throws InterruptedException {
        final DeleteUserCommandHandler service = new DeleteUserCommandHandler();

        Thread.sleep(600L);
        assertNotNull(service);
    }

}
