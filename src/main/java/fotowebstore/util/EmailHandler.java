package fotowebstore.util;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class EmailHandler {

    private static Properties props = System.getProperties();
    static {
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.user", "PTS4FotoWebStore");
        props.put("mail.smtp.password", "PTS4FotoWebStore!");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
    }

    public static void send(String to, String subject, String content) {
        Session session = Session.getInstance(props, null);
        MimeMessage message = new MimeMessage(session);

        try {
            String username = props.get("mail.smtp.user").toString();
            String password = props.get("mail.smtp.password").toString();

            InternetAddress from = new InternetAddress(username);
            message.setSubject(subject);
            message.setFrom(from);
            message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

            // Create the content
            message.setText(content);

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
