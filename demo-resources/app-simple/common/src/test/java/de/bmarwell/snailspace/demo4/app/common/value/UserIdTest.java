package de.bmarwell.snailspace.demo4.app.common.value;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserIdTest {


    @Test
    void test_user_id() throws InterruptedException {
        // given
        final String userId = "user-id";

        // when
        final UserId id = new UserId(userId);

        // then
        Assertions.assertThat(id).isEqualTo(new UserId(userId));
    }
}
