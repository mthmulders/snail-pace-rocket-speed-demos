package de.bmarwell.snailspace.demo4.app.services.commands;

public class AddUserCommandHandler implements CommandHandler<AddUserCommand, AddUserResponse>{

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
