package com.sports.sport.servicecontroller;

/**
 * @author adam
 * @created 19:49
 */

import com.sports.sport.SportApplication;
import com.sports.sport.message.Message;
import com.sports.sport.service.MessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SuppressWarnings({"checkstyle:WhitespaceAfter", "checkstyle:LineLength"})
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SportApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
public class EmailControllerTestIntegration {

    @SuppressWarnings("checkstyle:JavadocVariable")
    @LocalServerPort
    private int port;

    @SuppressWarnings("checkstyle:JavadocVariable")
    @Autowired
    private MockMvc mockMvc;

    @SuppressWarnings("checkstyle:JavadocVariable")
    @MockBean
    private MessageService messageService;
//PM2020T25-243
//Actions (Type . to access issue actions)
//PM2020T25-246
//Actions (Type . to access issue actions)
    @SuppressWarnings({"checkstyle:WhitespaceAfter", "checkstyle:LineLength", "checkstyle:WhitespaceAround", "checkstyle:MissingJavadocMethod"})
    @Test
    public void getInboxMail() throws Exception {

        Message message1 = new Message("111", "adham", "sdsadasdasd", "asasasas", "asasassa");
        message1.setId("1111");

        Message message2 = new Message("111", "adham", "sdsadasdasd", "asasasas", "asasassa");

        message2.setId("11112");
        List<Message> data = Arrays.asList(message1, message2);
        given(messageService.findAll()).willReturn(data);
        mockMvc.perform(
                get("http://localhost:" + port + "/managementEmail/viewInboxEmails/sdsadasdasd").contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }
    //PM2020T25-198
    //Actions (Type . to access issue actions)

    //PM2020T25-228
    //Actions (Type . to access issue actions)
    @SuppressWarnings({"checkstyle:WhitespaceAfter", "checkstyle:LineLength", "checkstyle:WhitespaceAround", "checkstyle:MissingJavadocMethod"})
    @Test
    public void getSendMail() throws Exception {

        Message message1 = new Message("111", "adham", "sdsadasdasd", "asasasas", "asasassa");
        message1.setId("1111");

        Message message2 = new Message("111", "adham", "sdsadasdasd", "asasasas", "asasassa");

        message2.setId("11112");
        List<Message> data = Arrays.asList(message1, message2);
        given(messageService.findAll()).willReturn(data);
        mockMvc.perform(
                get("http://localhost:" + port + "/managementEmail/viewSendEmails/adham").contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }


}
