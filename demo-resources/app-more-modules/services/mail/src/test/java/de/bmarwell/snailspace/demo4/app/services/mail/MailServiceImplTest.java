package de.bmarwell.snailspace.demo4.app.services.mail;

import static org.assertj.core.api.Assertions.assertThat;

import de.bmarwell.snailspace.demo4.app.services.api.MailSendStatus;
import de.bmarwell.snailspace.demo4.app.services.api.MailService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MailServiceImplTest {

    @Test
    void test() {
        final MailService service = new MailServiceImpl();

        // when
        final MailSendStatus mailSendStatus = service.sendMail("mail@mthmulders.invalid",
            "bmarwell@apache.invalid", "Test", "Test");

        // then
        assertThat(mailSendStatus).isNotNull();
        assertThat(mailSendStatus.status()).isEqualTo("sent");
    }

    @Test
    void expect_failure_invalid_sender() {
        final MailService service = new MailServiceImpl();

        // when
        final MailSendStatus mailSendStatus = service.sendMail("mail at mthmulders.invalid",
            "bmarwell@apache.invalid", "Test", "Test");

        // then
        assertThat(mailSendStatus).isNotNull();
        assertThat(mailSendStatus.status()).isEqualTo("invalid sender");
    }

    @Test
    void expect_failure_invalid_recipient() {
        final MailService service = new MailServiceImpl();

        // when
        final MailSendStatus mailSendStatus = service.sendMail("mail@mthmulders.invalid",
            "bmarwell_at_apache.invalid", "Test", "Test");

        // then
        assertThat(mailSendStatus).isNotNull();
        assertThat(mailSendStatus.status()).isEqualTo("invalid recipient");
    }

}
