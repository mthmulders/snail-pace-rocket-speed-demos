package de.bmarwell.snailspace.demo4.app.services.api.commands;

public interface CommandExecutorService {

    <R extends CommandResponse> R execute(ExecutableCommand<R> command);

}
