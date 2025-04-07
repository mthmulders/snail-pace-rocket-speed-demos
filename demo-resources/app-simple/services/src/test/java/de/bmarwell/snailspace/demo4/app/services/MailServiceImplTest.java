package de.bmarwell.snailspace.demo4.app.services;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MailServiceImplTest {

    @Test
    void test() throws InterruptedException {
        final MailService service = new MailServiceImpl();

        Thread.sleep(1_000L);
        Assertions.assertThat(service).isNotNull();
    }

}
