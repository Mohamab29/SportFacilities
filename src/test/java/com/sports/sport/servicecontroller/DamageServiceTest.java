package com.sports.sport.servicecontroller;

import com.sports.sport.ad.Advertisement;
import com.sports.sport.damage.Damage;
import com.sports.sport.repository.AdvertisementRepository;
import com.sports.sport.repository.RepositoryDamage;
import com.sports.sport.service.AdvertisementService;
import com.sports.sport.service.DamageService;
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
import static org.mockito.BDDMockito.*;
//testing the input of the form
//PM2020T25-157

/**
 * @author adam
 * @created 4:20
 */
@SuppressWarnings("checkstyle:JavadocType")
@RunWith(SpringRunner.class)
@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
public class DamageServiceTest {

    @SuppressWarnings("checkstyle:JavadocVariable")
    @MockBean
    private RepositoryDamage repositoryDamage;

    @SuppressWarnings("checkstyle:JavadocVariable")
    @Autowired
    private DamageService damageService;

    @SuppressWarnings("checkstyle:JavadocVariable")
    @MockBean
    private AdvertisementRepository advertisementRepository;

    @SuppressWarnings("checkstyle:JavadocVariable")
    @Autowired
    private AdvertisementService advertisementService;

    @SuppressWarnings("checkstyle:WhitespaceAround")
    @TestConfiguration
    static class DamageServiceContextConfiguration {
        @SuppressWarnings("checkstyle:WhitespaceAround")
        @Bean
        public DamageService damageService() {

            return new DamageService();
        }

        @SuppressWarnings("checkstyle:WhitespaceAround")
        @Bean
        public AdvertisementService advertisementService() {

            return new AdvertisementService();
        }
    }

    @SuppressWarnings({"checkstyle:WhitespaceAfter", "checkstyle:LineLength", "checkstyle:NoWhitespaceBefore", "checkstyle:MissingJavadocMethod"})
    @Test
    public void findAll() {
        Advertisement advertisement = new Advertisement("Football", "BeerSheva",
                "Mshahrerm", "4", "A", "", "", "yes", "", "",
                "", "", "String owner", "String forSchool"
                , "String association", "String sportType", "String lat", "String lon ");
        advertisement.setId("1");
        when(advertisementRepository.existsById(anyString())).thenReturn(true);
        given(advertisementRepository.findById(anyString())).willReturn(Optional.ofNullable(advertisement));

        Advertisement result = advertisementService.findById("1");
        Damage damage1 = new Damage(result.getId(), "high", "la la la la ", "la la la la la ");
        Damage damage2 = new Damage(result.getId(), "high", "la la la la ", "la la la la la ");
        List<Damage> data = Arrays.asList(damage1, damage2);
        given(repositoryDamage.findAll()).willReturn(data);
        assertThat(damageService.findAll())
                .contains(damage1, damage2).hasSize(2);
    }


    @SuppressWarnings({"checkstyle:LineLength", "checkstyle:WhitespaceAfter", "checkstyle:NoWhitespaceBefore", "checkstyle:MissingJavadocMethod"})
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

        Damage damage1 = new Damage(result.getId(), "high", "la la la la ", "la la la la la ");
        damage1.setId("11");

        when(repositoryDamage.existsById(anyString())).thenReturn(true);
        given(repositoryDamage.findById(anyString())).willReturn(Optional.ofNullable(damage1));
        Damage result1 = damageService.findById("11");
        System.out.println(result1.toString());
        assertThat(result1.getStatus()).containsIgnoringCase("high");


    }

    @SuppressWarnings({"checkstyle:WhitespaceAfter", "checkstyle:LineLength", "checkstyle:NoWhitespaceBefore", "checkstyle:MissingJavadocMethod"})
    @Test
    public void existsById() {
        Advertisement advertisement = new Advertisement("Football", "BeerSheva",
                "Mshahrerm", "4", "A", "", "", "yes", "", "",
                "", "", "String owner", "String forSchool"
                , "String association", "String sportType", "String lat", "String lon ");
        advertisement.setId("1");
        when(advertisementRepository.existsById(anyString())).thenReturn(true);
        given(advertisementRepository.findById(anyString())).willReturn(Optional.ofNullable(advertisement));
        Advertisement result = advertisementService.findById("1");

        Damage damage1 = new Damage(result.getId(), "high", "la la la la ", "la la la la la ");
        damage1.setId("11");

        when(repositoryDamage.existsById(anyString())).thenReturn(true);
        assertThat(damageService.existsById("11")).isEqualTo(true);
    }
}