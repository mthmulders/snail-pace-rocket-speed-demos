package de.bmarwell.snailspace.demo4.app.services.commands;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import de.bmarwell.snailspace.demo4.app.common.value.User;
import de.bmarwell.snailspace.demo4.app.common.value.UserId;
import de.bmarwell.snailspace.demo4.app.services.api.commands.AddUserCommand;
import de.bmarwell.snailspace.demo4.app.services.api.commands.AddUserResponse;
import org.junit.jupiter.api.Test;

class AddUserCommandHandlerTest {

    @Test
    void test_someone() throws InterruptedException {
        final AddUserCommandHandler service = new AddUserCommandHandler();
        final var command = new AddUserCommand(new User(new UserId("someone"), "someone"));

        // when
        final AddUserResponse commandResponse = service.execute(command);

        // then
        assertThat(commandResponse).isNotNull();
    }

    @Test
    void add_mthmulders() throws InterruptedException {
        final AddUserCommandHandler service = new AddUserCommandHandler();
        final var command = new AddUserCommand(new User(new UserId("mthmulders"), "Maarten"));

        // when
        final AddUserResponse commandResponse = service.execute(command);

        // then
        assertThat(commandResponse).isNotNull();
    }

    @Test
    void add_bmarwell() throws InterruptedException {
        final AddUserCommandHandler service = new AddUserCommandHandler();
        final var command = new AddUserCommand(new User(new UserId("bmarwell"), "Benjamin"));

        // when
        final AddUserResponse commandResponse = service.execute(command);

        // then
        assertThat(commandResponse).isNotNull();
    }

}
