package de.bmarwell.snailspace.demo4.app.services.commands;

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
