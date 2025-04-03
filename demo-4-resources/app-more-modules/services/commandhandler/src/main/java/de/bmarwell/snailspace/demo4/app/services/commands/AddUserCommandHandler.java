package de.bmarwell.snailspace.demo4.app.services.commands;

import de.bmarwell.snailspace.demo4.app.services.api.commands.AddUserCommand;
import de.bmarwell.snailspace.demo4.app.services.api.commands.AddUserResponse;
import de.bmarwell.snailspace.demo4.app.services.api.commands.CommandHandler;
import de.bmarwell.snailspace.demo4.app.services.api.commands.ExecutableCommand;

public class AddUserCommandHandler implements CommandHandler<AddUserCommand, AddUserResponse> {

    @Override
    public boolean canHandle(Class<ExecutableCommand<?>> commandClass) {
        return commandClass.isAssignableFrom(AddUserCommand.class);
    }

    @Override
    public AddUserResponse execute(AddUserCommand command) {
        throw new UnsupportedOperationException(
            "not yet implemented: [de.bmarwell.snailspace.demo4.app.services.commands.AddUserCommandHandler::execute].");
    }
}
