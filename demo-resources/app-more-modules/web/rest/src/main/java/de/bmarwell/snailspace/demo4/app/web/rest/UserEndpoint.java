package de.bmarwell.snailspace.demo4.app.web.rest;

import de.bmarwell.snailspace.demo4.app.services.api.UserService;
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
        try {
            Thread.sleep(Long.parseLong(System.getProperty("method.timeout", "100")));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return Response.ok("Users list").build();
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
