package de.bmarwell.snailspace.demo4.app.services.ldap;

import static org.junit.jupiter.api.Assertions.assertNotNull;

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
