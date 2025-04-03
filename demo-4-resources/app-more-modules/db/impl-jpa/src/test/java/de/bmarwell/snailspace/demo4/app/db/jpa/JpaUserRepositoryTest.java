package de.bmarwell.snailspace.demo4.app.db.jpa;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class JpaUserRepositoryTest {

    @Test
    void test() throws InterruptedException {
        final JpaUserRepository service = new JpaUserRepository();

        Thread.sleep(1_000L);
        Assertions.assertThat(service).isNotNull();
    }

}
