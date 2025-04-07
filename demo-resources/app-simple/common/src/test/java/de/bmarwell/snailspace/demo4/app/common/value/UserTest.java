package de.bmarwell.snailspace.demo4.app.common.value;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    void userTest() {
        // given
        final String userId = "user-id";
        final String name = "name";

        // when
        final User user = new User(new UserId(userId), name);

        // then
        assertAll(
                () -> assertEquals(userId, user.userId().value()),
                () -> assertEquals(name, user.name())
        );
    }

}
