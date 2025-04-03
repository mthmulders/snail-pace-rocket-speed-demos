package de.bmarwell.snailspace.demo4.app.common.lang;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class StreamHelperTest {

    @Test
    void test_user_id() throws InterruptedException {
        final StreamHelper sh = new StreamHelper();

        // then
        Thread.sleep(1_000L);
        Assertions.assertThat(sh).isEqualTo(new StreamHelper());
    }

}
