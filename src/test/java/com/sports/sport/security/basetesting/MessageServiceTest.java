package com.sports.sport.security.basetesting;


import com.sports.sport.ad.Advertisement;
import com.sports.sport.complaint.Complaint;
import com.sports.sport.damage.Damage;
import com.sports.sport.message.Message;
import com.sports.sport.repository.MessageRepository;
import com.sports.sport.repository.UserRepository;
import com.sports.sport.security.UserService;
import com.sports.sport.security.userDetails.ApplicationUser;
import com.sports.sport.service.MessageService;
import org.junit.Test;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.*;
import static org.assertj.core.api.Assertions.*;

/**
 * @author adam
 * @created 20:19
 */
@SuppressWarnings("checkstyle:JavadocType")
@RunWith(SpringRunner.class)
@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
public class MessageServiceTest {


    @SuppressWarnings("checkstyle:JavadocVariable")
    @MockBean
    private MessageRepository messageRepository;

    @SuppressWarnings("checkstyle:JavadocVariable")
    @Autowired
    private MessageService messageService;

    @SuppressWarnings("checkstyle:JavadocVariable")
    @MockBean
    private UserRepository userRepository;

    @SuppressWarnings("checkstyle:JavadocVariable")
    @Autowired
    private UserService userService;


    @SuppressWarnings("checkstyle:WhitespaceAround")
    @TestConfiguration
    static class MessageServiceContextConfiguration {
        @SuppressWarnings("checkstyle:WhitespaceAround")
        @Bean
        public MessageService messageService() {

            return new MessageService();
        }

        @SuppressWarnings("checkstyle:WhitespaceAround")
        @Bean
        public UserService userService() {

            return new UserService();
        }
    }


    @SuppressWarnings({"checkstyle:WhitespaceAfter", "checkstyle:LineLength", "checkstyle:MultipleVariableDeclarations", "checkstyle:WhitespaceAround", "checkstyle:MissingJavadocMethod"})
    @Test
    public void findAll() throws Exception {

        Message message1 = new Message("122", "adam1@sports.com", "2@gmail.com", "2222", "22222");
        Message message = new Message("1", "adam1@sports.com", "2@gmail.com", "2222", "22222");
        message1.setId("1111");
        Message message2 = new Message("1222", "adam1@sports.com", "2@gmail.com", "2222", "22222");
        message2.setId("22222");
        List<Message> data = Arrays.asList(message1, message2);
        given(messageRepository.findAll()).willReturn(data);
        assertThat(messageService.findAll())
                .contains(message1, message2).hasSize(2);
    }

    @SuppressWarnings({"checkstyle:LineLength", "checkstyle:WhitespaceAfter", "checkstyle:MultipleVariableDeclarations", "checkstyle:WhitespaceAround", "checkstyle:MissingJavadocMethod"})
    @Test
    public void inboxMail() {
        ApplicationUser user = new ApplicationUser("adam1", "adam1@sports.com", "12345", "0543843351", "30");
        user.setId("1234");
        ApplicationUser user2 = new ApplicationUser("adam1", "2@gmail.com", "12345", "0543843351", "30");
        user.setId("1235");
        when(userRepository.existsById(anyString())).thenReturn(true);
        given(userRepository.findByEmail(anyString())).willReturn(user2);
        ApplicationUser result = userService.findByEmail("2@gmail.com");
        Message message1 = new Message("122", "adam1@sports.com", "2@gmail.com", "2222", "22222");
        Message message = new Message("1", "adam1@sports.com", "2@gmail.com", "2222", "22222");
        message1.setId("1111");
        List<Message> data = Arrays.asList(message1);
        given(messageRepository.findByRecipientEmail(result.getUsername())).willReturn(data);
        assertThat(messageService.inboxMail(result.getUsername())).isEqualTo(data);


    }

    @SuppressWarnings({"checkstyle:LineLength", "checkstyle:WhitespaceAfter", "checkstyle:MultipleVariableDeclarations", "checkstyle:WhitespaceAround", "checkstyle:MissingJavadocMethod"})
    @Test
    public void sendMail() {
        ApplicationUser user = new ApplicationUser("adam1", "adam1@sports.com", "12345", "0543843351", "30");
        user.setId("1234");
        when(userRepository.existsById(anyString())).thenReturn(true);
        given(userRepository.findByEmail(anyString())).willReturn(user);
        ApplicationUser result = userService.findByEmail("adam1@sports.com");
        Message message1 = new Message("122", "adam1@sports.com", "2@gmail.com", "2222", "22222");
        Message message = new Message("1", "adam1@sports.com", "2@gmail.com", "2222", "22222");
        message1.setId("1111");
        List<Message> data = Arrays.asList(message1);
        given(messageRepository.findByUserNameSending(result.getUsername())).willReturn(data);
        assertThat(messageService.sendMail(result.getUsername())).isEqualTo(data);


    }

}
