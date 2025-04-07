package de.bmarwell.snailspace.demo4.app.services.commands;

import de.bmarwell.snailspace.demo4.app.services.api.commands.CommandHandler;
import de.bmarwell.snailspace.demo4.app.services.api.commands.ExecutableCommand;
import de.bmarwell.snailspace.demo4.app.services.api.commands.UpdateUserCommand;
import de.bmarwell.snailspace.demo4.app.services.api.commands.UpdateUserResponse;

public class UpdateUserCommandHandler implements CommandHandler<UpdateUserCommand, UpdateUserResponse> {

    @Override
    public boolean canHandle(Class<ExecutableCommand<?>> commandClass) {
        return commandClass.isAssignableFrom(UpdateUserCommand.class);
    }

    @Override
    public UpdateUserResponse execute(UpdateUserCommand command) {
        // TODO: implement
        throw new UnsupportedOperationException(
            "not yet implemented: [de.bmarwell.snailspace.demo4.app.services.commands.UpdateUserCommandHandler::execute].");
    }
}
