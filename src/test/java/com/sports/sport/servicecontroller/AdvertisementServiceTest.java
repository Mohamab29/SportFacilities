package com.sports.sport.servicecontroller;

import com.sports.sport.ad.Advertisement;
import com.sports.sport.repository.AdvertisementRepository;
import com.sports.sport.service.AdvertisementService;
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
import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.*;
//QA testing
//QA Testing - test the page of the advertisement
//PM2020T25-158
//PM2020T25-160
//PM2020T25-159
//PM2020T25-164

/**
 * @author adam
 * @created 4:19
 */
@SuppressWarnings("checkstyle:JavadocType")
@RunWith(SpringRunner.class)
@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
public class AdvertisementServiceTest {

    @SuppressWarnings("checkstyle:JavadocVariable")
    @MockBean
    private AdvertisementRepository advertisementRepository;

    @SuppressWarnings("checkstyle:JavadocVariable")
    @Autowired
    private AdvertisementService advertisementService;

    @SuppressWarnings("checkstyle:WhitespaceAround")
    @TestConfiguration
    static class AdvertisementServiceContextConfiguration {
        @SuppressWarnings("checkstyle:WhitespaceAround")
        @Bean
        public AdvertisementService advertisementService() {

            return new AdvertisementService();
        }
    }

    //PM2020T25-161
    //PM2020T25-170
    //result all sports fac
    @SuppressWarnings({"checkstyle:WhitespaceAfter", "checkstyle:NoWhitespaceBefore", "checkstyle:LineLength", "checkstyle:MissingJavadocMethod"})
    @Test
    public void findAll() {
        Advertisement advertisement1 = new Advertisement("Football", "BeerSheva",
                "Mshahrerm", "4", "A", "", "", "yes", "", "",
                "", "", "String owner", "String forSchool"
                , "String association", "String sportType", "String lat", "String lon ");
        Advertisement advertisement2 = new Advertisement("Football", "BeerSheva",
                "Mshahrerm", "4", "A", "", "", "yes", "", "",
                "", "", "String owner", "String forSchool"
                , "String association", "String sportType", "String lat", "String lon ");
        List<Advertisement> data = Arrays.asList(advertisement1, advertisement2);
        given(advertisementRepository.findAll()).willReturn(data);
        assertThat(advertisementService.findAll())
                .contains(advertisement1, advertisement2).hasSize(2);
    }

    //test the updating of the result
    @SuppressWarnings({"checkstyle:WhitespaceAfter", "checkstyle:LineLength", "checkstyle:NoWhitespaceBefore", "checkstyle:MissingJavadocMethod"})
    @Test
    public void update() {
        Advertisement advertisement1 = new Advertisement("Football", "BeerSheva",
                "Mshahrerm", "4", "A", "", "", "yes", "", "",
                "", "", "String owner", "String forSchool"
                , "String association", "String sportType", "String lat", "String lon ");
        assertEquals(advertisementService.update(advertisement1), "Advertisement not found");

    }

    @SuppressWarnings({"checkstyle:LineLength", "checkstyle:NoWhitespaceBefore", "checkstyle:WhitespaceAfter", "checkstyle:MissingJavadocMethod"})
    @Test
    public void findById() {

        Advertisement advertisement = new Advertisement("Football", "BeerSheva",
                "Mshahrerm", "4", "A", "", "", "yes", "", "",
                "", "", "String owner", "String forSchool"
                , "String association", "String sportType", "String lat", "String lon ");
        advertisement.setId("1");
        when(advertisementRepository.existsById(anyString())).thenReturn(true);
        given(advertisementRepository.findById(anyString())).willReturn(Optional.ofNullable(advertisement));

        Advertisement result = advertisementService.findById("1");
        assertThat(result.getType()).containsIgnoringCase("Football");


    }
}