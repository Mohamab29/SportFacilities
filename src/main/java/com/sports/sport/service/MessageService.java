package com.sports.sport.service;

import com.sports.sport.message.Message;
import com.sports.sport.message.SendEmail;
import com.sports.sport.repository.MessageRepository;
import com.sports.sport.security.UserService;
import com.sports.sport.security.userDetails.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.Date;
import java.util.List;

/**
 * @author adam
 * @created 19:28
 */
@SuppressWarnings("checkstyle:JavadocType")
@Service
public class MessageService {


    @SuppressWarnings("checkstyle:JavadocVariable")
    @Autowired
    private MessageRepository messageRepository;

    @SuppressWarnings("checkstyle:JavadocVariable")
    @Autowired
    private UserService userService;


    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public List<Message> findAll() {

        return messageRepository.findAll();
    }


    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public List<Message> inboxMail(String userName) {
        ApplicationUser applicationUser = userService.findByEmail(userName);
        if (applicationUser != null) {

            return messageRepository.findByRecipientEmail(userName);
        } else {
            return null;
        }

    }

    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:LineLength", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public List<Message> sendMail(String recipientEmail) {
        ApplicationUser applicationUser = userService.findByEmail(recipientEmail);
        if (applicationUser != null) {

            return messageRepository.findByUserNameSending(recipientEmail);
        } else {
            return null;
        }
    }

    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:LineLength", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public String adminToInspector(Message message) throws MessagingException {

        if (userService.existsById(message.getIdUser())) {
            message.setCreated(new Date());
            messageRepository.save(message);

            SendEmail.sendMail(message.getRecipientEmail(), message.getSubject(), message.getBody());

            return "your message sending to Inspector " + message.getRecipientEmail();
        } else {
            return "email not found";
        }

    }

    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:LineLength", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public String inspectorToAdmin(Message message) throws MessagingException {
        if (userService.existsById(message.getIdUser())) {
            message.setCreated(new Date());
            messageRepository.save(message);

            SendEmail.sendMail(message.getRecipientEmail(), message.getSubject(), message.getBody());

            return "Thank you for sending email to Admin " + message.getRecipientEmail();
        } else {
            return "email not found";
        }

    }

    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:WhitespaceAfter", "checkstyle:LineLength", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public String adminToClient(Message message) throws MessagingException {

        if (userService.existsById(message.getIdUser())) {
            message.setCreated(new Date());
            messageRepository.save(message);

            SendEmail.sendMail(message.getRecipientEmail(), message.getSubject(), message.getBody());

            return "sending email to " + message.getRecipientEmail();

        } else {

            return "email not found";
        }

    }

    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:WhitespaceAfter", "checkstyle:LineLength", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public String clientToAdmin(Message message) throws MessagingException {

        if (userService.existsById(message.getIdUser())) {
            message.setCreated(new Date());
            message.setRecipientEmail("admin@admin.com");
            messageRepository.save(message);

            SendEmail.sendMail("sports.facilities2021@gmail.com", message.getSubject(), message.getBody());

            return "sending email to Admin";

        } else {

            return "email not found";
        }

    }

    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:ParenPad", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public boolean existsById(String id) {

        return messageRepository.existsById(id);
    }

    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public List<Message> findById(String idUser) {

        return messageRepository.findByIdUser(idUser);
    }

}
