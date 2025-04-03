package de.bmarwell.snailspace.demo4.app.services.commands;

import de.bmarwell.snailspace.demo4.app.common.value.UserId;

public record DeleteUserCommand(UserId userId) implements ExecutableCommand<DeleteUserResponse> {

}
