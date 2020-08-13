package com.sports.sport.securityadv;

/**
 * @author adam
 * @created 19:50
 */

import com.sports.sport.SportApplication;
import com.sports.sport.damage.Damage;
import com.sports.sport.service.DamageService;
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

@SuppressWarnings({"checkstyle:WhitespaceAfter", "checkstyle:LineLength"})
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SportApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
public class DamageControllerTestIntegration {

    @SuppressWarnings("checkstyle:JavadocVariable")
    @LocalServerPort
    private int port;

    @SuppressWarnings("checkstyle:JavadocVariable")
    @Autowired
    private MockMvc mockMvc;

    @SuppressWarnings("checkstyle:JavadocVariable")
    @MockBean
    private DamageService damageService;

    @SuppressWarnings({"checkstyle:WhitespaceAfter", "checkstyle:LineLength", "checkstyle:WhitespaceAround", "checkstyle:MissingJavadocMethod"})
    @Test
    public void getAllDamages() throws Exception {

        Damage damage1 = new Damage("111", "high", "la la la la ", "la la la la la ");
        damage1.setId("11");
        Damage damage2 = new Damage("111", "high", "la la la la ", "la la la la la ");
        damage1.setId("12");
        List<Damage> data = Arrays.asList(damage1, damage2);
        given(damageService.findAll()).willReturn(data);
        mockMvc.perform(
                get("http://localhost:" + port + "/damage/getAllDamage").contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].status", equalTo(damage1.getStatus())));
    }


}
