package de.bmarwell.snailspace.demo4.app.services;

import de.bmarwell.snailspace.demo4.app.common.value.User;

public interface UserService {

    User updateUser(String userId, User user);
}
