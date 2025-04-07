package de.bmarwell.snailspace.demo4.app.services.commands;

public interface CommandHandler<T extends ExecutableCommand<R>, R extends CommandResponse> {

    boolean canHandle(Class<ExecutableCommand<?>> commandClass);

    R execute(T command);
}
