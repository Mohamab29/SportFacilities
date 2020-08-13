package com.sports.sport.security.signInController;
//PM2020T25-83 a Back end developer needs to build a Rest API for the Inspector user role .
//PM2020T25-82 a Back end developer needs to build a Rest API for the Client
// Controller Rest Api for Sign in with Roles
//PM2020T25-78 a Back end developer needs to build a Rest Api

import com.sports.sport.security.userDetails.ApplicationUser;
import com.sports.sport.security.SignInRequest;
import com.sports.sport.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

/**
 * @author adam
 * @created
 */
@CrossOrigin
@RestController
@RequestMapping("/api/v1/signIn")
public class SignInController {
    @SuppressWarnings("checkstyle:JavadocVariable")
    @Autowired
    private UserService userService;

    @SuppressWarnings("checkstyle:JavadocVariable")
    @Autowired
    private AuthenticationManager authenticationManager;

    @SuppressWarnings({"checkstyle:WhitespaceAfter", "checkstyle:LineLength", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    @PostMapping(value = {"", "/"})
    public ResponseSignIn signIn(@RequestBody SignInRequest signInRequest) {

        String password = null;

        try {
            final Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(signInRequest.getUsername(), signInRequest.getPassword())
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);

            UserDetails userDetails = userService.loadUserByUsername(signInRequest.getUsername());
            if (userDetails != null) {
                ApplicationUser applicationUser = userService.findByEmail(userDetails.getUsername());
                return new ResponseSignIn(applicationUser.getName(), applicationUser.getId(), applicationUser.getRole());
            }

        } catch (Exception e) {
            return new ResponseSignIn("not found", "", "");
        }

        return new ResponseSignIn("not found", "", "");
    }

}
