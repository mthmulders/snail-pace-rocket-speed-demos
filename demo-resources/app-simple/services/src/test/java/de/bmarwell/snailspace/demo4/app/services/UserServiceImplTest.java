package de.bmarwell.snailspace.demo4.app.services;

import de.bmarwell.snailspace.demo4.app.common.value.User;
import de.bmarwell.snailspace.demo4.app.common.value.UserId;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class UserServiceImplTest {

    @Test
    void test() {
        final UserServiceImpl userService = new UserServiceImpl();
        final UserId mthmulders = new UserId("mthmulders");

        // when
        final User maarten = userService.updateUser(mthmulders, new User(mthmulders, "Maarten"));

        // then
        Assertions.assertThat(maarten).isNotNull();
    }

}
