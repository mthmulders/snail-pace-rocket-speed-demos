package de.bmarwell.snailspace.demo4.app.common.lang;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class StreamHelperTest {

    @Test
    void test_user_id() {
        final StreamHelper sh = new StreamHelper();

        // then
        Assertions.assertThat(sh).isEqualTo(new StreamHelper());
    }

}
