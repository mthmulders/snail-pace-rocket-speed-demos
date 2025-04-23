package de.bmarwell.snailspace.demo4.app.services.api;

import java.util.List;

public interface GitHubService {

    List<String> queryRepositories(String searchTerm);
}
