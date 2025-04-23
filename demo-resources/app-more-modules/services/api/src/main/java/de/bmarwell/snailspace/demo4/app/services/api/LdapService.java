package de.bmarwell.snailspace.demo4.app.services.api;

import de.bmarwell.snailspace.demo4.app.common.value.User;
import de.bmarwell.snailspace.demo4.app.common.value.UserId;
import java.util.Optional;

public interface LdapService {

    Optional<User> getUser(UserId userId);
}
