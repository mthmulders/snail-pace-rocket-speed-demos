package de.bmarwell.snailspace.demo4.app.services;

import static org.assertj.core.api.Assertions.assertThat;

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
    void expect_failure() {
        final MailService service = new MailServiceImpl();

        // when
        final MailSendStatus mailSendStatus = service.sendMail("mail at mthmulders.invalid",
            "bmarwell@apache.invalid", "Test", "Test");

        // then
        assertThat(mailSendStatus).isNotNull();
        assertThat(mailSendStatus.status()).isEqualTo("invalid sender");
    }

}
