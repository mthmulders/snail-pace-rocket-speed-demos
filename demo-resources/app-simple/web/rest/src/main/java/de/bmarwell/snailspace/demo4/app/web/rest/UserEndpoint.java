package de.bmarwell.snailspace.demo4.app.web.rest;

import de.bmarwell.snailspace.demo4.app.services.UserService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("users")
@RequestScoped
public class UserEndpoint {

    @Inject
    UserService userService;

    @GET
    public Response getUsers() {
        return Response.ok("Users list").build();
    }


}
