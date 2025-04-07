package de.bmarwell.snailspace.demo4.app.services.commands;

import de.bmarwell.snailspace.demo4.app.services.api.commands.CommandExecutorService;
import de.bmarwell.snailspace.demo4.app.services.api.commands.CommandHandler;
import de.bmarwell.snailspace.demo4.app.services.api.commands.CommandResponse;
import de.bmarwell.snailspace.demo4.app.services.api.commands.ExecutableCommand;
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
