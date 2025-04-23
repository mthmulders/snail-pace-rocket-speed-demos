package de.bmarwell.snailspace.demo4.app.services.commands;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import de.bmarwell.snailspace.demo4.app.common.value.UserId;
import org.junit.jupiter.api.Test;

class UpdateUserCommandHandlerTest {

    @Test
    void delete_someone() {
        final UpdateUserCommandHandler service = new UpdateUserCommandHandler();
        final var command = new UpdateUserCommand(new UserId("someone"));

        // when
        final UpdateUserResponse updateUserResponse = service.execute(command);

        // then
        assertThat(updateUserResponse).isNotNull();
    }

    @Test
    void delete_mthmulders() {
        final UpdateUserCommandHandler service = new UpdateUserCommandHandler();
        final var command = new UpdateUserCommand(new UserId("mthmulders"));

        // when
        final UpdateUserResponse updateUserResponse = service.execute(command);

        // then
        assertThat(updateUserResponse).isNotNull();
    }

    @Test
    void delete_bmarwell() {
        final UpdateUserCommandHandler service = new UpdateUserCommandHandler();
        final var command = new UpdateUserCommand(new UserId("bmarwell"));

        // when
        final UpdateUserResponse updateUserResponse = service.execute(command);

        // then
        assertThat(updateUserResponse).isNotNull();
    }
}
