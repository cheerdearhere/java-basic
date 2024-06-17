package step05_designPatterns.facade.before;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Client {
    public static void main(String[] args) {
        String to = "hongildong@mail.com";
        String from = "gillim@mail.com";
        String host = "127.0.0.1";

        Properties props = System.getProperties();
        props.setProperty("mail.smt.host",host);

        Session session = Session.getDefaultInstance(props);
        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Test Mail from Java Program");
            message.setText("This is a test message");

            Transport.send(message);
        }catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
