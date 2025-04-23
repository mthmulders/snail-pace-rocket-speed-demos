package de.bmarwell.snailspace.demo4.app.services.health;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import de.bmarwell.snailspace.demo4.app.services.GitHubService;
import java.util.List;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.HealthCheckResponse.Status;
import org.junit.jupiter.api.Test;

class MpHealthServiceTest {

    @Test
    void test_down() {
        final GitHubService gitHubService = mock(GitHubService.class);
        when(gitHubService.queryRepositories("snailspace")).thenReturn(List.of());
        final MpHealthService service = new MpHealthService();
        service.setGitHubService(gitHubService);

        // when
        final HealthCheckResponse response = service.call();

        // then
        assertThat(response).isNotNull();
        assertThat(response.getStatus()).isEqualTo(Status.DOWN);
    }

    @Test
    void test_up() {
        final GitHubService gitHubService = mock(GitHubService.class);
        when(gitHubService.queryRepositories("snailspace"))
            .thenReturn(List.of("bmarwell/snailspace", "mthmulders/snailspace"));
        final MpHealthService service = new MpHealthService();
        service.setGitHubService(gitHubService);

        // when
        final HealthCheckResponse response = service.call();

        // then
        assertThat(response).isNotNull();
        assertThat(response.getStatus()).isEqualTo(Status.UP);
    }

}
