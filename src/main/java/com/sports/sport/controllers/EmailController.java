package com.sports.sport.controllers;

import com.sports.sport.message.Message;
import com.sports.sport.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;
//PM2020T25-206
//Actions (Type . to access issue actions)
/**
 * @author adam
 * @created 18:36
 */

@SuppressWarnings("checkstyle:JavadocType")
@CrossOrigin
@RequestMapping("/managementEmail")
@RestController
public class EmailController {

    @SuppressWarnings("checkstyle:JavadocVariable")
    @Autowired
    private MessageService messageService;

    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    @GetMapping("/viewInboxEmails/{emailUser}")
    public List<Message> viewInboxEmails(@PathVariable String emailUser) {

        return messageService.inboxMail(emailUser);
    }

    //PM2020T25-237
    //Actions (Type . to access issue actions)
    //PM2020T25-215
    //Actions (Type . to access issue actions)
    //PM2020T25-187
    //Actions (Type . to access issue actions)
    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    @GetMapping("/viewSendEmails/{emailUser}")
    public List<Message> viewSendEmails(@PathVariable String emailUser) {

        return messageService.sendMail(emailUser);
    }

    //PM2020T25-242
    //Actions (Type . to access issue actions)
    @SuppressWarnings({"checkstyle:FinalParameters", "checkstyle:LineLength", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    @PostMapping("/adminToInspector")
    public String adminToInspector(@RequestBody Message message) throws MessagingException {

        return messageService.adminToInspector(message);
    }

    @SuppressWarnings({"checkstyle:FinalParameters", "checkstyle:LineLength", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    @PostMapping("/inspectorToAdmin")
    public String inspectorToAdmin(@RequestBody Message message) throws MessagingException {

        return messageService.inspectorToAdmin(message);
    }

    @SuppressWarnings({"checkstyle:FinalParameters", "checkstyle:LineLength", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    @PostMapping("/adminToClient")
    public String adminToClient(@RequestBody Message message) throws MessagingException {

        return messageService.adminToClient(message);
    }

    @SuppressWarnings({"checkstyle:FinalParameters", "checkstyle:LineLength", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    @PostMapping("/clientToAdmin")
    public String clientToAdmin(@RequestBody Message message) throws MessagingException {

        return messageService.clientToAdmin(message);
    }

}
