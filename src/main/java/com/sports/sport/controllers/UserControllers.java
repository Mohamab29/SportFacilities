package com.sports.sport.controllers;

import com.sports.sport.security.UserService;
import com.sports.sport.security.userDetails.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;

/**
 * @author adam
 * @created 2:00
 */

@SuppressWarnings("checkstyle:JavadocType")
@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserControllers {

    @SuppressWarnings("checkstyle:JavadocVariable")
    @Autowired
    private UserService userService;


    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:WhitespaceAfter", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    @GetMapping(value = {"", "/"})
    public List<ApplicationUser> getUsers() {

        return userService.findAll();
    }


    //PM2020T25-229
    //Actions (Type . to access issue actions)
    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    @GetMapping(path = {"/{id}"})
    public ApplicationUser getUser(@PathVariable String id) {
        return userService.findById(id);
    }

    //Build Rest Api for delete account
//    /
    //PM2020T25-193
    //Actions (Type . to access issue actions)
    @SuppressWarnings({"checkstyle:FinalParameters", "checkstyle:LineLength", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    @DeleteMapping("/deleteUser/{id}")
    public String deleteAccount(@PathVariable String id) throws MessagingException {

        return userService.deleteByIdAccount(id);
    }
}
