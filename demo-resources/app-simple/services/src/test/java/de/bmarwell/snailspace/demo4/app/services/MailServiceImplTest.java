package de.bmarwell.snailspace.demo4.app.services;

import org.junit.jupiter.api.Test;

class MailServiceImplTest {

    @Test
    void test() {
        final MailService service = new MailServiceImpl();

        // when
        service.sendMail("mail@mthmulders.invalid", "bmarwell@apache.invalid", "Test", "Test");

        // expect no error
    }

}
