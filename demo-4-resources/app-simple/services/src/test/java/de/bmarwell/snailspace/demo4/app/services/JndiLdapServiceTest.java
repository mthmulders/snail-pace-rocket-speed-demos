package de.bmarwell.snailspace.demo4.app.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JndiLdapServiceTest {

    @Test
    void test() throws InterruptedException {
        final JndiLdapService service = new JndiLdapService();

        Thread.sleep(800L);
        assertNotNull(service);
    }

}
