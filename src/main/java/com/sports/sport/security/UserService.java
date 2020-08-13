package com.sports.sport.security;
//Create class service between the Controller Rest Api to  Repository Users **  /#PM2020T25-77

import com.sports.sport.error.NotFoundException;
import com.sports.sport.message.SendEmail;
import com.sports.sport.repository.UserRepository;
import com.sports.sport.security.userDetails.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.Date;
import java.util.List;

/**
 * @author adam
 * @created
 */

@Service
public class UserService implements UserDetailsService {


    @SuppressWarnings("checkstyle:JavadocVariable")
    @Autowired
    private UserRepository userRepository;

    @SuppressWarnings("checkstyle:WhitespaceAround")
    @Bean
    private PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:FinalParameters", "checkstyle:LineLength", "checkstyle:DesignForExtension"})
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        ApplicationUser user = userRepository.findByEmail(username);

        if (user == null) {
            throw new NotFoundException("User Not Found");
        }
        return user;

    }

    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void save(ApplicationUser user) {
        //PM2020T25-116 Add security for Rest password
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        this.userRepository.save(user);
    }

    //just for update
    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void save2(ApplicationUser user) {

        this.userRepository.save(user);
    }

    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public ApplicationUser findById(String id) {

        if (userRepository.existsById(id)) {

            return userRepository.findById(id).get();
        } else {

            return null;
        }
    }

    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public boolean existsById(String id) {

        return userRepository.existsById(id);
    }


    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public List<ApplicationUser> findAll() {
        return userRepository.findAll();
    }

    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public ApplicationUser findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @SuppressWarnings({"checkstyle:LineLength", "checkstyle:WhitespaceAround", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void insertNewUser(ApplicationUser user) {
//        PM2020T25-117 Add security for Sign-Up
//        PM2020T25-116 Add security for Rest password
        //PM2020T25-84 a Back end developer needs to build a Rest API for the Client user role(Register)
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        user.setJoin(new Date());
        userRepository.insert(user);
    }

    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public boolean existsByEmail(String email) {

        return userRepository.existsByEmail(email);
    }

    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:WhitespaceAfter", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void saveForRestPassword(ApplicationUser user, String newPassword) {

        //PM2020T25-116 Add security for Rest password
        user.setPassword(passwordEncoder().encode(newPassword));
        this.userRepository.save(user);
    }

    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:WhitespaceAfter", "checkstyle:LineLength", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public String deleteByIdAccount(String id) throws MessagingException {

        if (userRepository.existsById(id)) {
            ApplicationUser applicationUser = userRepository.findById(id).get();

            SendEmail.sendMail(applicationUser.getUsername(), "Delete Account Sports facilities", "Your Account Deleted");
            userRepository.deleteById(id);
            return "Account deleted !";
        } else {
            return "account not found";
        }
    }
}
