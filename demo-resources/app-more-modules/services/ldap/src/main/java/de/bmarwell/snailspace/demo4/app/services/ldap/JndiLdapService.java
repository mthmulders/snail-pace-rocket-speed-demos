package de.bmarwell.snailspace.demo4.app.services.ldap;

import de.bmarwell.snailspace.demo4.app.common.value.User;
import de.bmarwell.snailspace.demo4.app.common.value.UserId;
import de.bmarwell.snailspace.demo4.app.services.api.LdapService;
import java.util.Optional;

public class JndiLdapService implements LdapService {

    public Optional<User> getUser(UserId userId) {
        try {
            Thread.sleep(Long.parseLong(System.getProperty("method.timeout", "100")));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (userId.value().equals("bmarwell")) {
            return Optional.of(new User(userId, "Benjamin"));
        }

        if (userId.value().equals("mthmulders")) {
            return Optional.of(new User(userId, "Maarten"));
        }

        return Optional.empty();
    }
}
