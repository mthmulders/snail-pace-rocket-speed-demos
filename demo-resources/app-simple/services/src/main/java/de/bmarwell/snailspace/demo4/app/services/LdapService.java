package de.bmarwell.snailspace.demo4.app.services;

import de.bmarwell.snailspace.demo4.app.common.value.UserId;

public interface LdapService {

    String getUser(UserId userId);
}
