package de.bmarwell.snailspace.demo4.app.services.ldap;

import de.bmarwell.snailspace.demo4.app.services.api.LdapService;

public class JndiLdapService implements LdapService {

    public String getUser(String userId) {
        try {
            Thread.sleep(Long.parseLong(System.getProperty("method.timeout")));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return "user";
    }
}
