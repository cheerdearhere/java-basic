package step05_designPatterns.facade.after;

import javax.mail.Transport;

public class Client {
    public static void main(String[] args) {
        String to = "hongildong@mail.com";
        String from = "gillim@mail.com";
        String host = "127.0.0.1";
        String subject = "Test Mail from Java Program";
        String text = "This is a test mail";

        EmailSettings emailSettings = new EmailSettings();
        emailSettings.setHost(host);
        EmailSender emailSender = new EmailSender(emailSettings);
        EmailMessage emailMessage = new EmailMessage();
        emailMessage.setSubject(subject);
        emailMessage.setFrom(from);
        emailMessage.setTo(to);
        emailMessage.setText(text);
        emailMessage.setCc("hongil@mail.com");
        emailMessage.setBcc("gallam@mail.com");
        emailSender.sendEmail(emailMessage);
    }
}
