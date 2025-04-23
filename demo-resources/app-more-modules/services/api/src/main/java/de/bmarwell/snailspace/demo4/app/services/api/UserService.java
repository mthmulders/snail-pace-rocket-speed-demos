package de.bmarwell.snailspace.demo4.app.services.api;

import de.bmarwell.snailspace.demo4.app.common.value.User;
import de.bmarwell.snailspace.demo4.app.common.value.UserId;

public interface UserService {

    User updateUser(UserId userId, User user);
}
