package de.bmarwell.snailspace.demo4.app.services.user;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class UserServiceImplTest {

    @Test
    void test() throws InterruptedException {
        final UserServiceImpl userService = new UserServiceImpl();

        Thread.sleep(1_000L);
        Assertions.assertThat(userService).isNotNull();
    }

}
