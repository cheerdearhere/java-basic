package step05_designPatterns.facade.after;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailSender {
    private final EmailSettings emailSettings;
    public EmailSender(EmailSettings emailSettings) {
        this.emailSettings = emailSettings;
    }
    public void sendEmail(EmailMessage emailMessage) {
        Properties props = System.getProperties();
        props.setProperty("mail.smt.host",emailSettings.getHost());

        Session session = Session.getDefaultInstance(props);
        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(emailMessage.getFrom()));
            message.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress(emailMessage.getTo()));
            message.addRecipient(MimeMessage.RecipientType.CC, new InternetAddress(emailMessage.getCc()));
            message.addRecipient(MimeMessage.RecipientType.BCC, new InternetAddress(emailMessage.getBcc()));
            message.setSubject(emailMessage.getSubject());
            message.setText(emailMessage.getText());

            Transport.send(message);
        }catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
