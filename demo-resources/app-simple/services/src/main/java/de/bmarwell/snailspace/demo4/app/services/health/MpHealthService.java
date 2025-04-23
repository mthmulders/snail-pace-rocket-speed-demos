package de.bmarwell.snailspace.demo4.app.services.health;

import de.bmarwell.snailspace.demo4.app.services.GitHubService;
import jakarta.inject.Inject;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;

public class MpHealthService implements HealthService, HealthCheck {

    @Inject
    private GitHubService gitHubService;

    @Override
    public HealthCheckResponse call() {
        try {
            Thread.sleep(Long.parseLong(System.getProperty("method.timeout", "100")));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (gitHubService == null || gitHubService.queryRepositories("snailspace").isEmpty()) {
            return HealthCheckResponse.down("MpHealthService");
        }

        return HealthCheckResponse.up("MpHealthService");
    }

    public void setGitHubService(GitHubService gitHubService) {
        this.gitHubService = gitHubService;
    }
}
