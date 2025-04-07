package de.bmarwell.snailspace.demo4.app.services.db;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class JpaMailOutboxRepositoryTest {

    @Test
    void test() throws InterruptedException {
        final JpaMailOutboxRepository service = new JpaMailOutboxRepository();

        Thread.sleep(500L);
        Assertions.assertThat(service).isNotNull();
    }


}
