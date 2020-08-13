package com.sports.sport.controllers;

import com.sports.sport.security.UserService;
import com.sports.sport.security.resetPassword.SendMailUtil;
import com.sports.sport.security.userDetails.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

/**
 * @author adam
 * @created 18:50
 */
//class for add different Users
@SuppressWarnings("checkstyle:JavadocType")
@CrossOrigin
@RequestMapping("/editUser")
@RestController
public class EditUsersController {


    @SuppressWarnings("checkstyle:JavadocVariable")
    @Autowired
    private UserService userService;

    @SuppressWarnings({"checkstyle:FinalParameters", "checkstyle:LineLength", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    @DeleteMapping("deleteUser/{id}")
    public String deleteUser(@PathVariable String id) throws MessagingException {

        return userService.deleteByIdAccount(id);
    }

    //PM2020T25-184
    //Actions (Type . to access issue actions)
    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:LineLength", "checkstyle:WhitespaceAfter", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    @PostMapping("/addInspector")
    public String addInspector(@RequestBody ApplicationUser applicationUser) throws MessagingException {

        if (userService.existsByEmail(applicationUser.getUsername())) {

            return "that username is taken. try another";
        }
        SendMailUtil.sendMail(applicationUser.getUsername(), applicationUser.getPassword());
        applicationUser.setRole("2");
        userService.insertNewUser(applicationUser);
        return "Welcome , " + applicationUser.getName() + " You're new a member of the best website Be'er Sheva Sports facilities";

    }

    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:LineLength", "checkstyle:WhitespaceAfter", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    @PostMapping("/addAdmin")
    public String addAdmin(@RequestBody ApplicationUser applicationUser) throws MessagingException {

        if (userService.existsByEmail(applicationUser.getUsername())) {

            return "that username is taken. try another";
        }
        SendMailUtil.sendMail(applicationUser.getUsername(), applicationUser.getPassword());
        applicationUser.setRole("1");
        userService.insertNewUser(applicationUser);
        return "Welcome , " + applicationUser.getName() + " You're new a member of the best website Be'er Sheva Sports facilities";

    }

    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:LineLength", "checkstyle:WhitespaceAfter", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    @PostMapping("/addClient")
    public String addClient(@RequestBody ApplicationUser applicationUser) throws MessagingException {

        if (userService.existsByEmail(applicationUser.getUsername())) {

            return "that username is taken. try another";
        }
        SendMailUtil.sendMail(applicationUser.getUsername(), applicationUser.getPassword());
        applicationUser.setRole("3");
        userService.insertNewUser(applicationUser);
        return "Welcome , " + applicationUser.getName() + " You're new a member of the best website Be'er Sheva Sports facilities";

    }


}
