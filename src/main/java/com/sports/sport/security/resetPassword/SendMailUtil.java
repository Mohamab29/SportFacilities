package com.sports.sport.security.resetPassword;

//PM2020T25-80 a Back end developer needs to build a Rest API rest password

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@SuppressWarnings({"checkstyle:LineLength", "checkstyle:HideUtilityClassConstructor"})
public class SendMailUtil {
    @SuppressWarnings({"checkstyle:WhitespaceAfter", "checkstyle:LineLength", "checkstyle:FinalParameters", "checkstyle:NoWhitespaceBefore", "checkstyle:MissingJavadocMethod"})
    public static void sendMail(String recipient, String newPassword) throws MessagingException {

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
        Message message = prepareMessage(session, myAccountEmail, recipient, newPassword);
        Transport.send(message);
        System.out.println("send message is successfully");

    }

    @SuppressWarnings({"checkstyle:OperatorWrap", "checkstyle:WhitespaceAround", "checkstyle:LineLength", "checkstyle:WhitespaceAfter", "checkstyle:FinalParameters", "checkstyle:NoWhitespaceBefore"})
    private static Message prepareMessage(Session session, String myAccountEmail, String recipient, String newPassword) throws MessagingException {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(myAccountEmail));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
        message.setSubject("New Password From Be'er Sheva Sports facilities");
        message.setText("Your Username : Your Email" + "\n" + "New Password is : " + newPassword + "\n" + "Best,\n" +
                "\n" +
                "Team 25 Sami Shamoon \n" +
                "Admin WebSite\n" +
                "XYZ Marketing\n" +
                "555-555-5555\n" +
                "admin@sports.com");

        return message;
    }
}
