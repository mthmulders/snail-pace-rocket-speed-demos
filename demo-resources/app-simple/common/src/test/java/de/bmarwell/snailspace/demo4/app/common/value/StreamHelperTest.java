package de.bmarwell.snailspace.demo4.app.common.value;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class StreamHelperTest {

    @Test
    void test_user_id() throws InterruptedException {
        final StreamHelper sh = new StreamHelper();

        // then
        Assertions.assertThat(sh).isEqualTo(new StreamHelper());
    }

}
