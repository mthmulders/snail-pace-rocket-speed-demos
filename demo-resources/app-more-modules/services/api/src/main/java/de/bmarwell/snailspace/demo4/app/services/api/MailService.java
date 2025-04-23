package de.bmarwell.snailspace.demo4.app.services.api;

public interface MailService {

    MailSendStatus sendMail(String from, String to, String subject, String body);
}
