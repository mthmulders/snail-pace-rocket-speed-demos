package de.bmarwell.snailspace.demo4.app.services.commands;

public class DeleteUserCommandHandler implements CommandHandler<DeleteUserCommand, DeleteUserResponse> {

    @Override
    public boolean canHandle(Class<ExecutableCommand<?>> commandClass) {
        return commandClass.isAssignableFrom(DeleteUserCommand.class);
    }

    @Override
    public DeleteUserResponse execute(DeleteUserCommand command) {
        try {
            Thread.sleep(Long.parseLong(System.getProperty("method.timeout", "100")));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return new DeleteUserResponse();
    }
}
