package com.sports.sport.controllers;

/**
 * @author adam
 * @created 19:50
 */

import com.sports.sport.SportApplication;
import com.sports.sport.complaint.Complaint;
import com.sports.sport.security.UserService;
import com.sports.sport.security.userDetails.ApplicationUser;
import com.sports.sport.service.MessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.BDDMockito.*;
import static org.hamcrest.Matchers.*;

@SuppressWarnings({"checkstyle:WhitespaceAfter", "checkstyle:LineLength"})
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SportApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
public class UserControllersTestIntegration {

    @SuppressWarnings("checkstyle:JavadocVariable")
    @LocalServerPort
    private int port;

    @SuppressWarnings("checkstyle:JavadocVariable")
    @Autowired
    private MockMvc mockMvc;

    @SuppressWarnings("checkstyle:JavadocVariable")
    @MockBean
    private UserService userService;

    //Delete Users
    @SuppressWarnings({"checkstyle:MagicNumber", "checkstyle:LineLength", "checkstyle:MissingJavadocMethod"})
    @Test
    public void deleteUsers() throws Exception {
        Mockito.when(userService.deleteByIdAccount("10001L")).thenReturn("Account deleted !");
        mockMvc.perform(MockMvcRequestBuilders.delete("/users/deleteUser/10001L", 10001L))
                .andExpect(status().isOk());
    }


    @SuppressWarnings({"checkstyle:WhitespaceAfter", "checkstyle:LineLength", "checkstyle:WhitespaceAround", "checkstyle:MissingJavadocMethod"})
    @Test
    public void getAllUsers() throws Exception {

        ApplicationUser user1 = new ApplicationUser("adam1", "adam1@sports.com", "12345", "0543843351", "30");
        user1.setId("1111");
        ApplicationUser user2 = new ApplicationUser("adam1", "adam1@sports.com", "12345", "0543843351", "30");
        user1.setId("1112");
        List<ApplicationUser> data = Arrays.asList(user1, user2);
        given(userService.findAll()).willReturn(data);
        mockMvc.perform(
                get("http://localhost:" + port + "/users").contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", equalTo(user1.getName())));
    }
}
