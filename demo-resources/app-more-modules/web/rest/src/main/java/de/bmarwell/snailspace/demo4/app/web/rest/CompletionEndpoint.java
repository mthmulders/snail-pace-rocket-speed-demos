package de.bmarwell.snailspace.demo4.app.web.rest;

import de.bmarwell.snailspace.demo4.app.services.api.GitHubService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("completions")
@RequestScoped
public class CompletionEndpoint {

    @Inject
    GitHubService gitHubService;

    @GET
    public Response getCompletions() {
        try {
            Thread.sleep(Long.parseLong(System.getProperty("method.timeout", "100")));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return Response.ok(this.gitHubService.queryRepositories("terms")).build();
    }

    public void setGitHubService(GitHubService gitHubService) {
        this.gitHubService = gitHubService;
    }
}
