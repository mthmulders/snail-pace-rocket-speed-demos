package de.bmarwell.snailspace.demo4.app.services.commands;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AddUserCommandHandlerTest {

    @Test
    void test() throws InterruptedException {
        final AddUserCommandHandler service = new AddUserCommandHandler();

        Thread.sleep(500L);
        assertNotNull(service);
    }

}
