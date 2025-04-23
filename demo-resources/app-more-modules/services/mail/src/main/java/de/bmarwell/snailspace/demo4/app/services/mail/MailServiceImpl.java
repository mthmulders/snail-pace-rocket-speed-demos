package de.bmarwell.snailspace.demo4.app.services.mail;

import de.bmarwell.snailspace.demo4.app.common.value.MailId;
import de.bmarwell.snailspace.demo4.app.services.api.MailSendStatus;
import de.bmarwell.snailspace.demo4.app.services.api.MailService;
import java.util.UUID;

public class MailServiceImpl implements MailService {

    public MailSendStatus sendMail(String from, String to, String subject, String body) {
        try {
            Thread.sleep(Long.parseLong(System.getProperty("method.timeout", "100")));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (!from.contains("@")) {
            return new MailSendStatus(new MailId(UUID.randomUUID()), "invalid sender");
        }

        if (!to.contains("@")) {
            return new MailSendStatus(new MailId(UUID.randomUUID()), "invalid recipient");
        }

        return new MailSendStatus(new MailId(UUID.randomUUID()), "sent");
    }
}
