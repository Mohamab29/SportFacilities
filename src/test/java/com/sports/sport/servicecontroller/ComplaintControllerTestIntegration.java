package com.sports.sport.servicecontroller;


import com.sports.sport.SportApplication;
import com.sports.sport.complaint.Complaint;
import com.sports.sport.service.ComplaintService;
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

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author adam
 * @created 18:48
 */
@SuppressWarnings({"checkstyle:WhitespaceAfter", "checkstyle:LineLength", "checkstyle:JavadocType"})
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SportApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
public class ComplaintControllerTestIntegration {


    @SuppressWarnings("checkstyle:JavadocVariable")
    @LocalServerPort
    private int port;

    @SuppressWarnings("checkstyle:JavadocVariable")
    @Autowired
    private MockMvc mockMvc;

    @SuppressWarnings("checkstyle:JavadocVariable")
    @MockBean
    private ComplaintService complaintService;


    //PM2020T25-201
    //PM2020T25-210
    //Actions (Type . to access issue actions)
//Actions (Type . to access issue actions)
    @SuppressWarnings({"checkstyle:WhitespaceAfter", "checkstyle:LineLength", "checkstyle:WhitespaceAround", "checkstyle:MissingJavadocMethod"})
    @Test
    public void getAllComplaint() throws Exception {

        Complaint complaint1 = new Complaint("111", "aaaa", "hello", "Heeey", "", "");
        complaint1.setId("1");
        Complaint complaint2 = new Complaint("112", "aaaa", "hello", "Heeey", "", "");
        complaint2.setId("2");
        List<Complaint> data = Arrays.asList(complaint1, complaint2);
        given(complaintService.findAll()).willReturn(data);
        mockMvc.perform(
                get("http://localhost:" + port + "/complaint/findAllComplaint").contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].body", equalTo(complaint1.getBody())));
    }
}
