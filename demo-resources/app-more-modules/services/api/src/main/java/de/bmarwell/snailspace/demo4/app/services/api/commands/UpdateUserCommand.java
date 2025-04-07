package de.bmarwell.snailspace.demo4.app.services.api.commands;

import de.bmarwell.snailspace.demo4.app.common.value.UserId;

public record UpdateUserCommand(UserId userId) implements ExecutableCommand<UpdateUserResponse> {

}
