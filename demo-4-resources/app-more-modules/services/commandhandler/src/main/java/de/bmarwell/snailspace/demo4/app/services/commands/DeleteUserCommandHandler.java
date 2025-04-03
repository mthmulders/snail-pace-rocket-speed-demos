package de.bmarwell.snailspace.demo4.app.services.commands;

import de.bmarwell.snailspace.demo4.app.services.api.commands.CommandHandler;
import de.bmarwell.snailspace.demo4.app.services.api.commands.DeleteUserCommand;
import de.bmarwell.snailspace.demo4.app.services.api.commands.DeleteUserResponse;
import de.bmarwell.snailspace.demo4.app.services.api.commands.ExecutableCommand;

public class DeleteUserCommandHandler implements
    CommandHandler<DeleteUserCommand, DeleteUserResponse> {

    @Override
    public boolean canHandle(Class<ExecutableCommand<?>> commandClass) {
        return commandClass.isAssignableFrom(DeleteUserCommand.class);
    }

    @Override
    public DeleteUserResponse execute(DeleteUserCommand command) {
        // TODO: implement
        throw new UnsupportedOperationException(
            "not yet implemented: [de.bmarwell.snailspace.demo4.app.services.commands.DeleteUserCommandHandler::execute].");
    }
}
