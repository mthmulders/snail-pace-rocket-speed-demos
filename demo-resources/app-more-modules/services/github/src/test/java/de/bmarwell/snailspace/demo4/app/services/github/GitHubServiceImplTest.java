package de.bmarwell.snailspace.demo4.app.services.github;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class GitHubServiceImplTest {

    @Test
    void test() {
        final GitHubServiceImpl service = new GitHubServiceImpl();

        // when
        final List<String> repositories = service.queryRepositories("someone");

        // then
        assertThat(repositories).isEmpty();
    }

    @Test
    void find_bmarwell() {
        final GitHubServiceImpl service = new GitHubServiceImpl();

        // when
        final List<String> repositories = service.queryRepositories("bmarwell");

        // then
        Assertions.assertThat(repositories).isNotEmpty();
        Assertions.assertThat(repositories).contains("snailspace");
    }

    @Test
    void find_mthmulders() {
        final GitHubServiceImpl service = new GitHubServiceImpl();

        // when
        final List<String> repositories = service.queryRepositories("mthmulders");

        // then
        Assertions.assertThat(repositories).isNotEmpty();
        Assertions.assertThat(repositories).contains("snailspace");
    }
}
