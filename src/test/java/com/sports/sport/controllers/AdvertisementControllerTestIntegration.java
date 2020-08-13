package com.sports.sport.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sports.sport.SportApplication;
import com.sports.sport.ad.Advertisement;
import com.sports.sport.service.AdvertisementService;
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

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.BDDMockito.*;
import static org.hamcrest.Matchers.*;

/**
 * @author adam
 * @created 3:19
 */
@SuppressWarnings({"checkstyle:WhitespaceAfter", "checkstyle:LineLength", "checkstyle:JavadocType"})
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SportApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
public class AdvertisementControllerTestIntegration {

    @SuppressWarnings("checkstyle:JavadocVariable")
    @LocalServerPort
    private int port;

    @SuppressWarnings("checkstyle:JavadocVariable")
    @Autowired
    private MockMvc mockMvc;

    @SuppressWarnings("checkstyle:JavadocVariable")
    @MockBean
    private AdvertisementService advertisementService;


    @SuppressWarnings({"checkstyle:WhitespaceAfter", "checkstyle:LineLength", "checkstyle:NoWhitespaceBefore", "checkstyle:WhitespaceAround", "checkstyle:MissingJavadocMethod"})
    @Test
    public void getAllAdvertisement() throws Exception {

        Advertisement advertisement1 = new Advertisement("Football", "BeerSheva",
                "Mshahrerm", "4", "A", "", "", "yes", "", "",
                "", "", "String owner", "String forSchool"
                , "String association", "String sportType", "String lat", "String lon ");
        advertisement1.setId("1");
        Advertisement advertisement2 = new Advertisement("Football", "BeerSheva",
                "Mshahrerm", "4", "A", "", "", "yes", "", "",
                "", "", "String owner", "String forSchool"
                , "String association", "String sportType", "String lat", "String lon ");
        advertisement1.setId("2");
        List<Advertisement> data = Arrays.asList(advertisement1, advertisement2);
        given(advertisementService.findAll()).willReturn(data);
        mockMvc.perform(
                get("http://localhost:" + port + "/category/getCategoryAd").contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", equalTo(advertisement1.getName())));
    }

    @SuppressWarnings({"checkstyle:WhitespaceAfter", "checkstyle:LineLength", "checkstyle:NoWhitespaceBefore", "checkstyle:WhitespaceAround", "checkstyle:MissingJavadocMethod"})
    @Test
    public void postAdvertisment() throws Exception {
        Advertisement advertisement1 = new Advertisement("Football", "BeerSheva",
                "Mshahrerm", "4", "A", "", "", "yes", "", "",
                "", "", "String owner", "String forSchool"
                , "String association", "String sportType", "String lat", "String lon ");
        advertisement1.setId("1");
        Advertisement advertisement2 = new Advertisement("Football", "BeerSheva",
                "Mshahrerm", "4", "A", "", "", "yes", "", "",
                "", "", "String owner", "String forSchool"
                , "String association", "String sportType", "String lat", "String lon ");
        advertisement1.setId("2");
        List<Advertisement> data = Arrays.asList(advertisement1, advertisement2);
        given(advertisementService.findAll()).willReturn(data);
        mockMvc.perform(
                get("http://localhost:" + port + "/category/getCategoryAd").contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", equalTo(advertisement1.getName())));

    }
}