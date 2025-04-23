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
        try {
            Thread.sleep(Long.parseLong(System.getProperty("method.timeout", "100")));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return new UpdateUserResponse();
    }
}
