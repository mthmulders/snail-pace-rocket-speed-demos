package de.bmarwell.snailspace.demo4.app.services;

import static org.junit.jupiter.api.Assertions.*;

import de.bmarwell.snailspace.demo4.app.common.value.UserId;
import org.junit.jupiter.api.Test;

class JndiLdapServiceTest {

    @Test
    void test() {
        final JndiLdapService service = new JndiLdapService();

        // when
        final String mthmulders = service.getUser(new UserId("mthmulders"));

        // then
        assertNotNull(mthmulders);
    }

}
