package de.bmarwell.snailspace.demo4.app.web.rest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CompletionServiceTest {

    @Test
    void test() throws InterruptedException {
        final CompletionEndpoint completionService = new CompletionEndpoint();
        Thread.sleep(500L);

        assertThat(completionService).isNotNull();
    }
  
}
