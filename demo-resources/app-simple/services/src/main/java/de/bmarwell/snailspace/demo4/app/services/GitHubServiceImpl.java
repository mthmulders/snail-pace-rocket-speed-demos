package de.bmarwell.snailspace.demo4.app.services;

import java.util.List;

public class GitHubServiceImpl implements GitHubService {

    public List<String> queryRepositories(String searchTerm) {
        try {
            Thread.sleep(Long.parseLong(System.getProperty("method.timeout")));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return List.of();
    }
}
