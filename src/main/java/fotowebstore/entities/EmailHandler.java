package fotowebstore.entities;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class EmailHandler {

    private Properties props;

    public EmailHandler() {
        props = System.getProperties();
        props.put("mail.smtp.starttls.enable", true);
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.user", "PTS4FotoWebStore");
        props.put("mail.smtp.password", "PTS4FotoWebStore!");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", true);
    }

    public void send(String to, String subject, String content) {
        Session session = Session.getInstance(props, null);
        MimeMessage message = new MimeMessage(session);

        try {
            String username = props.get("mail.smtp.user").toString();
            String password = props.get("mail.smtp.password").toString();

            InternetAddress from = new InternetAddress(username);
            message.setSubject(subject);
            message.setFrom(from);
            message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

            // Create a multi-part to combine the parts
            Multipart multipart = new MimeMultipart("alternative");

            // Create the html part
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(content, "text/html");

            // Add html part to multi part
            multipart.addBodyPart(messageBodyPart);

            // Associate multi-part with message
            message.setContent(multipart);

            // Send message
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", username, password);
            transport.sendMessage(message, message.getAllRecipients());
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
