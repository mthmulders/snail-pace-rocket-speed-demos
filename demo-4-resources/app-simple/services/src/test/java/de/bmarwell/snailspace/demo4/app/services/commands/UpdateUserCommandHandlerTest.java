package de.bmarwell.snailspace.demo4.app.services.commands;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UpdateUserCommandHandlerTest {

    @Test
    void test() throws InterruptedException {
        final UpdateUserCommandHandler service = new UpdateUserCommandHandler();

        Thread.sleep(750L);
        assertNotNull(service);
    }

}
