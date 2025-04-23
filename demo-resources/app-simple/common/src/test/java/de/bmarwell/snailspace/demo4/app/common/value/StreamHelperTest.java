package de.bmarwell.snailspace.demo4.app.common.value;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class StreamHelperTest {

    @Test
    void test_user_id() {
        final StreamHelper sh = new StreamHelper();

        // then
        Assertions.assertThat(sh).isEqualTo(new StreamHelper());
    }

    @Test
    void test_copy_to() throws IOException {
        // given
        final var in = new ByteArrayInputStream("test".getBytes(StandardCharsets.UTF_8));
        final var out = new ByteArrayOutputStream();

        // when
        StreamHelper.copyTo(in, out);

        // then
        assertThat(out.toByteArray()).isNotNull();
        final String output = out.toString(StandardCharsets.UTF_8);
        assertThat(output).isEqualTo("test");
    }

}
