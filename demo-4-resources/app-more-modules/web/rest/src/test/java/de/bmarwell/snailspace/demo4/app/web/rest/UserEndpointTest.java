package de.bmarwell.snailspace.demo4.app.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class UserEndpointTest {

    @Test
    void test() throws InterruptedException {
        final UserEndpoint completionService = new UserEndpoint();
        Thread.sleep(500L);

        assertThat(completionService).isNotNull();
    }

}
