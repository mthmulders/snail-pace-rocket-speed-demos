package de.bmarwell.snailspace.demo4.app.services.user;

import de.bmarwell.snailspace.demo4.app.common.value.User;
import de.bmarwell.snailspace.demo4.app.services.api.UserService;

public class UserServiceImpl implements UserService {

    public User updateUser(String userId, User user) {
        try {
            Thread.sleep(Long.parseLong(System.getProperty("method.timeout")));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return user;
    }
}
