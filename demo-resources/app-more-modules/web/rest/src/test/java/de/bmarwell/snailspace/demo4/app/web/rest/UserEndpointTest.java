package de.bmarwell.snailspace.demo4.app.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import de.bmarwell.snailspace.demo4.app.services.api.UserService;
import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.Test;

class UserEndpointTest {

    @Test
    void test() {
        final UserEndpoint completionService = new UserEndpoint();
        completionService.setUserService(mock(UserService.class));

        // when
        final Response response = completionService.getUsers();

        // then
        assertThat(response).isNotNull();
    }

}
