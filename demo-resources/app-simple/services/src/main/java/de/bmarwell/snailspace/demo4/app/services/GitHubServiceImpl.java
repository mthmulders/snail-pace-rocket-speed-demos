package de.bmarwell.snailspace.demo4.app.services;

import java.util.List;

public class GitHubServiceImpl implements GitHubService {

    public List<String> queryRepositories(String searchTerm) {
        try {
            Thread.sleep(Long.parseLong(System.getProperty("method.timeout", "100")));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (searchTerm.contains("bmarwell")) {
            return List.of("bmarwell", "snailspace");
        }

        if (searchTerm.contains("mthmulders")) {
            return List.of("mthmulders", "snailspace");
        }

        return List.of();
    }
}
