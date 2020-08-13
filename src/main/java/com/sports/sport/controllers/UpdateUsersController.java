package com.sports.sport.controllers;

import com.sports.sport.security.UserService;
import com.sports.sport.security.userDetails.ApplicationUser;
import com.sports.sport.security.userDetails.ApplicationUserUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//PM2020T25-224
//Actions (Type . to access issue actions)
/**
 * @author adam
 * @created 19:23
 */
//PM2020T25-190
//Actions (Type . to access issue actions)
@SuppressWarnings("checkstyle:JavadocType")
@RestController
@CrossOrigin
@RequestMapping("/updateAccount")
public class UpdateUsersController {


    @SuppressWarnings("checkstyle:JavadocVariable")
    @Autowired
    private UserService userService;

    //PM2020T25-233
    //Actions (Type . to access issue actions)
    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:LineLength", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    @PostMapping("/updateRole")
    public String updateRoleUser(@RequestBody ApplicationUserUpdate applicationUserUpdate) {

        if (userService.existsById(applicationUserUpdate.getId())) {
            ApplicationUser applicationUser = userService.findById(applicationUserUpdate.getId());

            applicationUser.setRole(applicationUserUpdate.getRole());

            userService.save2(applicationUser);

            return "Your User Update!";
        } else {

            return "User not found";
        }
    }

    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:LineLength", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    @PostMapping("/changePassword")
    public String changePassword(@RequestBody ApplicationUser applicationUser) {

        if (userService.existsById(applicationUser.getId())) {

            ApplicationUser applicationUser1 = userService.findById(applicationUser.getId());
            applicationUser1.setPassword(applicationUser.getPassword());
            userService.save(applicationUser1);
            return "your password updated";
        } else {
            return "user not found";
        }
    }

    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:LineLength", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    @PostMapping("/changeEmail")
    public String changeEmail(@RequestBody ApplicationUser applicationUser) {
        ApplicationUser user = userService.findByEmail(applicationUser.getUsername());

        if (userService.existsById(applicationUser.getId()) && user == null) {

            ApplicationUser applicationUser1 = userService.findById(applicationUser.getId());
            applicationUser1.setEmail(applicationUser.getUsername());
            userService.save2(applicationUser1);
            return "your email updated";
        } else {
            return "user not found";
        }
    }

    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:LineLength", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    @PostMapping("/changeName")
    public String changeName(@RequestBody ApplicationUser applicationUser) {

        if (userService.existsById(applicationUser.getId())) {

            ApplicationUser applicationUser1 = userService.findById(applicationUser.getId());
            applicationUser1.setName(applicationUser.getName());
            userService.save2(applicationUser1);
            return "your name updated";
        } else {
            return "user not found";
        }
    }

    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:LineLength", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    @PostMapping("/changePhone")
    public String changePhone(@RequestBody ApplicationUser applicationUser) {

        if (userService.existsById(applicationUser.getId())) {

            ApplicationUser applicationUser1 = userService.findById(applicationUser.getId());
            applicationUser1.setPhone(applicationUser.getPhone());
            userService.save2(applicationUser1);
            return "your phone updated";
        } else {
            return "user not found";
        }
    }
}
