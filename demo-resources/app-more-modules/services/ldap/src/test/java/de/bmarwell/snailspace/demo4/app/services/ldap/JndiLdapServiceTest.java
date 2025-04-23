package de.bmarwell.snailspace.demo4.app.services.ldap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import de.bmarwell.snailspace.demo4.app.common.value.User;
import de.bmarwell.snailspace.demo4.app.common.value.UserId;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class JndiLdapServiceTest {

    @Test
    void test() {
        final JndiLdapService service = new JndiLdapService();

        // when
        final Optional<User> user = service.getUser(new UserId("someone"));

        // then
        assertNotNull(user);
        assertThat(user).isNotPresent();
    }

    @Test
    void test_bmarwell() {
        final JndiLdapService service = new JndiLdapService();

        // when
        final Optional<User> user = service.getUser(new UserId("bmarwell"));

        // then
        assertNotNull(user);
        assertThat(user).isPresent();
        assertThat(user.orElseThrow().name()).isEqualTo("Benjamin");
    }

    @Test
    void test_mthmulders() {
        final JndiLdapService service = new JndiLdapService();

        // when
        final Optional<User> user = service.getUser(new UserId("mthmulders"));

        // then
        assertNotNull(user);
        assertThat(user).isPresent();
        assertThat(user.orElseThrow().name()).isEqualTo("Maarten");
    }

}
