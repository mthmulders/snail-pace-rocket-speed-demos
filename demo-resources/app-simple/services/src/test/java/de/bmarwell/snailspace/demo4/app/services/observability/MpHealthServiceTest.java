package de.bmarwell.snailspace.demo4.app.services.observability;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MpHealthServiceTest {

    @Test
    void test() throws InterruptedException {
        final MpHealthService service = new MpHealthService();

        Thread.sleep(1_000L);
        Assertions.assertThat(service).isNotNull();
    }

}
