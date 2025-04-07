package de.bmarwell.snailspace.demo4.app.services.api.commands;

import de.bmarwell.snailspace.demo4.app.common.value.User;

public record AddUserCommand(User user) implements ExecutableCommand<AddUserResponse> {

}
