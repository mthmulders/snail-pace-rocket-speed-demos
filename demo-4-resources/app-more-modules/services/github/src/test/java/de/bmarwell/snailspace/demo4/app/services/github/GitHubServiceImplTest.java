package de.bmarwell.snailspace.demo4.app.services.github;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class GitHubServiceImplTest {

    @Test
    void test() throws InterruptedException {
        final GitHubServiceImpl service = new GitHubServiceImpl();

        Thread.sleep(1_000L);
        Assertions.assertThat(service).isNotNull();
    }

}
