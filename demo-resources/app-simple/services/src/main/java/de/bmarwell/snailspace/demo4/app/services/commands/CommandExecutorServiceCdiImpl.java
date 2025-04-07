package de.bmarwell.snailspace.demo4.app.services.commands;

import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;

public class CommandExecutorServiceCdiImpl implements CommandExecutorService {

    @Inject
    Instance<CommandHandler> commandHandlers;

    @Override
    public <R extends CommandResponse> R execute(ExecutableCommand<R> command) {
        var handler = this.commandHandlers.stream()
            .filter(commandHandler -> commandHandler.canHandle(command.getClass()))
            .findAny();
        return null;
    }
}
