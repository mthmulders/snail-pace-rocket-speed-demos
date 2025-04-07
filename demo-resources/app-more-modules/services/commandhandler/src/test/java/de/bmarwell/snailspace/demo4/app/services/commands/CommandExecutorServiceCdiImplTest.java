package de.bmarwell.snailspace.demo4.app.services.commands;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CommandExecutorServiceCdiImplTest {

    @Test
    void test() throws InterruptedException {
        final CommandExecutorServiceCdiImpl service = new CommandExecutorServiceCdiImpl();

        Thread.sleep(500L);
        Assertions.assertThat(service).isNotNull();
    }

}
