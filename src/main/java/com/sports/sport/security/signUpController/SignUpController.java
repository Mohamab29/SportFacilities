package com.sports.sport.security.signUpController;
//PM2020T25-84 a Back end developer needs to build a Rest API for the Client user role(Register)

import com.sports.sport.security.resetPassword.SendMailUtil;
import com.sports.sport.security.userDetails.ApplicationUser;
import com.sports.sport.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

/**
 * @author adam
 * @created 2020
 */
@SuppressWarnings("checkstyle:JavadocType")
@CrossOrigin
@RestController
@RequestMapping("/api/v1/signUp")
public class SignUpController {

    @SuppressWarnings("checkstyle:JavadocVariable")
    @Autowired
    private UserService userService;


    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:LineLength", "checkstyle:WhitespaceAfter", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    @PostMapping(value = {"", "/"})
    public String signUp(@RequestBody ApplicationUser applicationUser) throws MessagingException {

        if (userService.existsByEmail(applicationUser.getUsername())) {

            return "that username is taken. try another";
        }
        SendMailUtil.sendMail(applicationUser.getUsername(), applicationUser.getPassword());
        applicationUser.setRole("3");
        userService.insertNewUser(applicationUser);
        return "Welcome , " + applicationUser.getName() + " You're new a member of the best website Be'er Sheva Sports facilities";

    }
}
