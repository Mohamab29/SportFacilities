package com.sports.sport.security.resetPassword;
//PM2020T25-80 a Back end developer needs to build a Rest API rest password

import com.sports.sport.security.UserService;
import com.sports.sport.security.signUpController.EmailRestPassword;
import com.sports.sport.security.userDetails.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;

/**
 * @author adam
 * @created
 */
@CrossOrigin
@RestController
@RequestMapping("/api/v1/restPassword")
public class RestPasswordController {

    @SuppressWarnings("checkstyle:JavadocVariable")
    @Autowired
    private UserService userService;


    @SuppressWarnings({"checkstyle:WhitespaceAfter", "checkstyle:WhitespaceAround", "checkstyle:FinalParameters", "checkstyle:LineLength", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    @PostMapping({"", "/"})
    public String restPassword(@RequestBody EmailRestPassword email) throws MessagingException {
        String newPassword = getAlphaNumericString();
        if (userService.existsByEmail(email.getEmail())) {
            SendMailUtil.sendMail(email.getEmail(), newPassword);
            ApplicationUser applicationUser = new ApplicationUser();
            List<ApplicationUser> list = userService.findAll();
            for (ApplicationUser user : list
            ) {
                applicationUser = user;
            }
            userService.saveForRestPassword(applicationUser, newPassword);
            return "please check your email to reset your password";

        }

        return "The User Not Found";
    }

    //for generate new Password
    @SuppressWarnings({"checkstyle:WhitespaceAfter", "checkstyle:LocalVariableName", "checkstyle:MagicNumber", "checkstyle:WhitespaceAround", "checkstyle:LeftCurly"})
    static String getAlphaNumericString() {

        int n = 10;
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            int index
                    = (int) (AlphaNumericString.length()
                    * Math.random());
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }
}
