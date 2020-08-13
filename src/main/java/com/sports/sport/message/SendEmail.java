package com.sports.sport.message;


import javax.mail.*;
import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * @author adam
 * @created 18:59
 */
@SuppressWarnings({"checkstyle:LineLength", "checkstyle:HideUtilityClassConstructor", "checkstyle:JavadocType"})
public class SendEmail {
    @SuppressWarnings({"checkstyle:WhitespaceAfter", "checkstyle:LineLength", "checkstyle:FinalParameters", "checkstyle:NoWhitespaceBefore", "checkstyle:MissingJavadocMethod"})
    public static void sendMail(String recipient, String subject, String body) throws MessagingException {

        Properties properties = new Properties();

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        String myAccountEmail = "sports.facilities2021@gmail.com";
        String password = "aymm12345678";
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @SuppressWarnings("checkstyle:WhitespaceAfter")
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });
        javax.mail.Message message = prepareMessage(session, myAccountEmail, recipient, subject, body);
        Transport.send(message);
//        System.out.println("send message is successfully");

    }

    @SuppressWarnings({"checkstyle:WhitespaceAfter", "checkstyle:LineLength", "checkstyle:FinalParameters", "checkstyle:NoWhitespaceBefore"})
    private static javax.mail.Message prepareMessage(Session session, String myAccountEmail, String recipient, String subject, String body) throws MessagingException {
        javax.mail.Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(myAccountEmail));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
        message.setSubject(subject);
        message.setText(body);

        return message;
    }
}
