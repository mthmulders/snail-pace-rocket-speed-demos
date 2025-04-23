package de.bmarwell.snailspace.demo4.app.services;

public class MailServiceImpl implements MailService{

    public void sendMail(String from, String to, String subject, String body) {
        try {
            Thread.sleep(Long.parseLong(System.getProperty("method.timeout")));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
