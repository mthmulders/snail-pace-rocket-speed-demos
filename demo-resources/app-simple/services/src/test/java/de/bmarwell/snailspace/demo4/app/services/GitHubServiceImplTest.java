package de.bmarwell.snailspace.demo4.app.services;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class GitHubServiceImplTest {

    @Test
    void test() {
        final GitHubServiceImpl service = new GitHubServiceImpl();

        // when
        final List<String> repositories = service.queryRepositories("mthmulders");

        // then
        assertThat(repositories).isEmpty();
    }

}
