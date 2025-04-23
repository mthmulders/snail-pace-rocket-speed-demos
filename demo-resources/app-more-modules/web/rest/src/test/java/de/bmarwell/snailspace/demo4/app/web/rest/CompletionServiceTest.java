package de.bmarwell.snailspace.demo4.app.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import de.bmarwell.snailspace.demo4.app.services.api.GitHubService;
import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.Test;

class CompletionServiceTest {

    @Test
    void test() {
        final CompletionEndpoint completionService = new CompletionEndpoint();
        completionService.setGitHubService(mock(GitHubService.class));

        // when
        final Response completions = completionService.getCompletions();

        // then
        assertThat(completions).isNotNull();
    }
  
}
