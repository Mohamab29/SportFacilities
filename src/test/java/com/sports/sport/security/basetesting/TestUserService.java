package com.sports.sport.security.basetesting;


import com.sports.sport.SportApplication;
import com.sports.sport.repository.UserRepository;
import com.sports.sport.security.UserService;
import com.sports.sport.security.userDetails.ApplicationUser;
import org.junit.Test;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.*;
import static org.assertj.core.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SuppressWarnings({"checkstyle:LineLength", "checkstyle:LeftCurly"})
@RunWith(SpringRunner.class)
@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
public class TestUserService {

    @SuppressWarnings("checkstyle:JavadocVariable")
    @MockBean
    private UserRepository userRepository;

    @SuppressWarnings("checkstyle:JavadocVariable")
    @Autowired
    private UserService userService;

//    @Autowired
//    private MockMvc mockMvc;

    @SuppressWarnings("checkstyle:WhitespaceAround")
    @TestConfiguration
    static class UserServiceContextConfiguration {
        @SuppressWarnings("checkstyle:WhitespaceAround")
        @Bean
        public UserService userService() {

            return new UserService();
        }
    }
    //    PM2020T25-125 --Unit Test Method Rest Password - Send Email with new password , check Users DataBase

    @SuppressWarnings({"checkstyle:WhitespaceAfter", "checkstyle:LineLength", "checkstyle:MissingJavadocMethod"})
    @Test
    public void findAll() {
        ApplicationUser user1 = new ApplicationUser("adam1", "adam1@sports.com", "12345", "0543843351", "30");
        ApplicationUser user2 = new ApplicationUser("adam2", "adam1@sports.com", "123456", "0543843351", "30");
        List<ApplicationUser> data = Arrays.asList(user1, user2);
        given(userRepository.findAll()).willReturn(data);
        assertThat(userService.findAll())
                .contains(user1, user2).hasSize(2);
    }


    //PM2020T25-123 Unit Test login username and password method-
    @SuppressWarnings({"checkstyle:WhitespaceAfter", "checkstyle:LineLength", "checkstyle:MissingJavadocMethod"})
    @Test
    public void loadUserByUsername() {
        ApplicationUser user = new ApplicationUser("adam1", "adam1@sports.com", "12345", "0543843351", "30");
        user.setId("1234");
        given(userRepository.findByEmail(user.getUsername())).willReturn(user);
        assertThat(userService.findByEmail(user.getUsername())).isEqualTo(user);
    }


    //    PM2020T25-124 Unit Test Sign-Up new User
    @SuppressWarnings({"checkstyle:WhitespaceAfter", "checkstyle:LineLength", "checkstyle:MissingJavadocMethod"})
    @Test
    public void save() {
        ApplicationUser user = new ApplicationUser("adam1", "adam1@sports.com", "12345", "0543843351", "30");
        user.setId("1234");
        given(userRepository.save(user)).willReturn(null);
        assertThat(userService.findByEmail(user.getUsername()));
    }
    //    PM2020T25-125 --Unit Test Method Rest Password - Send Email with new password , check Users DataBase


    @SuppressWarnings({"checkstyle:WhitespaceAfter", "checkstyle:LineLength", "checkstyle:MissingJavadocMethod"})
    @Test
    public void findByEmail() {
        ApplicationUser user = new ApplicationUser("adam1", "adam1@sports.com", "12345", "0543843351", "30");
        user.setId("1234");
        given(userRepository.save(user)).willReturn(null);
        assertThat(userService.findByEmail(user.getUsername()));
    }

    //    PM2020T25-125 --Unit Test Method Rest Password - Send Email with new password , check Users DataBase
    @SuppressWarnings({"checkstyle:WhitespaceAfter", "checkstyle:LineLength", "checkstyle:MissingJavadocMethod"})
    @Test
    public void insertNewUser() {
        ApplicationUser user = new ApplicationUser("adam1", "adam1@sports.com", "12345", "0543843351", "30");
        user.setId("1234");
        given(userRepository.insert(user)).willReturn(null);
        assertThat(userService.findByEmail(user.getUsername()));
    }
    //    PM2020T25-125 --Unit Test Method Rest Password - Send Email with new password , check Users DataBase

    @SuppressWarnings({"checkstyle:LineLength", "checkstyle:WhitespaceAfter", "checkstyle:MissingJavadocMethod"})
    @Test
    public void existsByEmail() {
        ApplicationUser user = new ApplicationUser("adam1", "adam1@sports.com", "12345", "0543843351", "30");
        user.setId("1234");
        given(userRepository.insert(user)).willReturn(null);
        given(userRepository.existsByEmail(user.getUsername())).willReturn(true);
        assertThat(userService.existsByEmail(user.getUsername()));
    }

    //PM2020T25 -- Rest Password For all Users /Admin /inspector/ Client
    @SuppressWarnings({"checkstyle:WhitespaceAfter", "checkstyle:LineLength", "checkstyle:MissingJavadocMethod"})
    @Test
    public void saveForRestPassword() {
        ApplicationUser user = new ApplicationUser("adam1", "adam1@sports.com", "12345", "0543843351", "30");
        user.setId("1234");
        given(userRepository.save(user)).willReturn(null);
        assertThat(userService.findByEmail(user.getUsername()));
    }

    //add Inspector
    @SuppressWarnings({"checkstyle:WhitespaceAfter", "checkstyle:LineLength", "checkstyle:MissingJavadocMethod"})
    @Test
    public void addInspector() {
        ApplicationUser user = new ApplicationUser("adam1", "adam1@sports.com", "12345", "0543843351", "30");
        user.setId("1234");
        user.setRole("2");
        given(userRepository.save(user)).willReturn(null);
        assertThat(userService.findByEmail(user.getUsername()));
    }

    //update details
    @SuppressWarnings({"checkstyle:WhitespaceAfter", "checkstyle:LineLength", "checkstyle:MissingJavadocMethod"})
    @Test
    public void updateDetails() {
        ApplicationUser user = new ApplicationUser("adam1", "adam1@sports.com", "12345", "0543843351", "30");
        user.setId("1234");
        user.setRole("2");
        given(userRepository.save(user)).willReturn(null);
        assertThat(userService.findByEmail(user.getUsername()));
    }

    //Inspector Update details
    @SuppressWarnings({"checkstyle:WhitespaceAfter", "checkstyle:LineLength", "checkstyle:MissingJavadocMethod"})
    @Test
    public void updateDetailsInspector() {
        ApplicationUser user = new ApplicationUser("adam1", "adam1@sports.com", "12345", "0543843351", "30");
        user.setId("1234");
        user.setRole("2");
        given(userRepository.save(user)).willReturn(null);
        assertThat(userService.findByEmail(user.getUsername()));
    }


}