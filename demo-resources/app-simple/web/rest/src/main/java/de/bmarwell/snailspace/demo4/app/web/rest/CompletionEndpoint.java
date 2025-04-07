package de.bmarwell.snailspace.demo4.app.web.rest;

import de.bmarwell.snailspace.demo4.app.services.GitHubService;
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
        return Response.ok("Completions list").build();
    }

}
