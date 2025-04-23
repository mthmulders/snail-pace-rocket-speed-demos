package de.bmarwell.snailspace.demo4.app.services;

public interface MailService {

    void sendMail(String from, String to, String subject, String body);
}
