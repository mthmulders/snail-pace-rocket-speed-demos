package de.bmarwell.snailspace.demo4.app.services.commands;

public class AddUserCommandHandler implements CommandHandler<AddUserCommand, AddUserResponse>{

    @Override
    public boolean canHandle(Class<ExecutableCommand<?>> commandClass) {
        return commandClass.isAssignableFrom(AddUserCommand.class);
    }

    @Override
    public AddUserResponse execute(AddUserCommand command) {
        try {
            Thread.sleep(Long.parseLong(System.getProperty("method.timeout", "100")));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return new AddUserResponse();
    }
}
