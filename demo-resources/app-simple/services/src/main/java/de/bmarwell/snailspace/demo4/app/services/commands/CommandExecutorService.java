package de.bmarwell.snailspace.demo4.app.services.commands;

public interface CommandExecutorService {

    <R extends CommandResponse> R execute(ExecutableCommand<R> command);

}
