package com.sports.sport.servicecontroller;

import com.sports.sport.complaint.Complaint;
import com.sports.sport.repository.ComplaintRepository;
import com.sports.sport.repository.UserRepository;
import com.sports.sport.security.UserService;
import com.sports.sport.security.userDetails.ApplicationUser;
import com.sports.sport.service.ComplaintService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

/**
 * @author adam
 * @created 4:16
 */
@SuppressWarnings("checkstyle:JavadocType")
@RunWith(SpringRunner.class)
@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
public class ComplaintServiceTest {


    @SuppressWarnings("checkstyle:JavadocVariable")
    @MockBean
    private ComplaintRepository complaintRepository;

    @SuppressWarnings("checkstyle:JavadocVariable")
    @Autowired
    private ComplaintService complaintService;

    @SuppressWarnings("checkstyle:JavadocVariable")
    @MockBean
    private UserRepository userRepository;

    @SuppressWarnings("checkstyle:JavadocVariable")
    @Autowired
    private UserService userService;


    @SuppressWarnings("checkstyle:WhitespaceAround")
    @TestConfiguration
    static class ComplaintServiceContextConfiguration {
        @SuppressWarnings("checkstyle:WhitespaceAround")
        @Bean
        public ComplaintService complaintService() {

            return new ComplaintService();
        }

        @SuppressWarnings("checkstyle:WhitespaceAround")
        @Bean
        public UserService userService() {

            return new UserService();
        }

    }

//PM2020T25-200
//Actions (Type . to access issue actions)
    @SuppressWarnings({"checkstyle:WhitespaceAfter", "checkstyle:LineLength", "checkstyle:WhitespaceAround", "checkstyle:MissingJavadocMethod"})
    @Test
    public void findAll() {

        Complaint complaint1 = new Complaint("1", "adham", "hello", "la la la la ", "No", "yes yes ");
        Complaint complaint2 = new Complaint("1", "adham", "hello", "la la la la ", "No", "yes yes ");
        List<Complaint> data = Arrays.asList(complaint1, complaint2);
        given(complaintRepository.findAll()).willReturn(data);
        assertThat(complaintService.findAll())
                .contains(complaint1, complaint2).hasSize(2);

    }

    //PM2020T25-213
    //Actions (Type . to access issue actions)
    @SuppressWarnings({"checkstyle:LineLength", "checkstyle:WhitespaceAfter", "checkstyle:WhitespaceAround", "checkstyle:MissingJavadocMethod"})
    @Test
    public void findByIdUser() {

        ApplicationUser user = new ApplicationUser("adam1", "adam1@sports.com", "12345", "0543843351", "30");
        user.setId("1234");
        when(userRepository.existsById(anyString())).thenReturn(true);
        given(userRepository.findById(anyString())).willReturn(Optional.ofNullable(user));
        ApplicationUser result = userService.findById("1234");
        Complaint complaint = new Complaint("1234", "adam1", "hello", "la la la la ", "No", "yes yes ");
        complaint.setId("1111");
        List<Complaint> data = Arrays.asList(complaint);
        given(complaintRepository.findByIdUser(result.getId())).willReturn(data);
        assertThat(complaintService.findByIdUser(result.getId())).isEqualTo(data);

    }

}
