package de.bmarwell.snailspace.demo4.app.services.ldap;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class JndiLdapServiceTest {

    @Test
    void test() throws InterruptedException {
        final JndiLdapService service = new JndiLdapService();

        Thread.sleep(800L);
        assertNotNull(service);
    }

}
