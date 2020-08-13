package com.sports.sport.service;

import com.sports.sport.ad.Advertisement;
import com.sports.sport.repository.ReservationRepository;
import com.sports.sport.reservation.Reservation;
import com.sports.sport.security.UserService;
import com.sports.sport.security.userDetails.ApplicationUser;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

/**
 * @author adam
 * @created 0:12
 */
@SuppressWarnings("checkstyle:JavadocType")
@RunWith(SpringRunner.class)
@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
public class ReservationServiceTest {


    @SuppressWarnings("checkstyle:JavadocVariable")
    @MockBean
    private ReservationRepository reservationRepository;
    @SuppressWarnings("checkstyle:JavadocVariable")
    @Autowired
    private ReservationService reservationService;


    @SuppressWarnings("checkstyle:JavadocVariable")
    @MockBean
    private AdvertisementService advertisementService;


    @SuppressWarnings("checkstyle:JavadocVariable")
    @MockBean
    private UserService userService;

    @TestConfiguration
    static class ReservationServiceContextConfiguration {
        @Bean
        public ReservationService reservationService() {
            return new ReservationService();
        }
    }


    @SuppressWarnings({"checkstyle:LineLength", "checkstyle:WhitespaceAfter", "checkstyle:NoWhitespaceBefore", "checkstyle:MissingJavadocMethod"})
    @Test
    public void addReservation() throws MessagingException {

        ApplicationUser user = new ApplicationUser("adam1", "adam1@sports.com", "12345", "0543843351", "30");
        user.setId("1234");
        user.setRole("1");
        Advertisement advertisement = new Advertisement("Football", "BeerSheva",
                "Mshahrerm", "4", "A", "", "", "yes", "", "",
                "", "", "String owner", "String forSchool"
                , "String association", "String sportType", "String lat", "String lon ");
        Reservation reservation = new Reservation("111", user.getId(), new Date(), new Date(), "4", "lalal", user.getName(),
                user.getUsername());
        reservation.setId("1234");
        given(advertisementService.checkAdvertisementAvailable(reservation.getIdApplicationUser())).willReturn(true);
        given(advertisementService.existsById(reservation.getIdAdvertisement())).willReturn(true);
        given(userService.existsById(reservation.getIdApplicationUser())).willReturn(true);
        given(userService.findById(anyString())).willReturn(user);
        given(advertisementService.findById(anyString())).willReturn(advertisement);
        given(reservationRepository.save(reservation)).willReturn(null);
        //If add all condition - the return change to "Your Reservation Accept !";
        assertThat(reservationService.addReservation(reservation)).isEqualTo("Your Reservation Reject!");

    }

    @SuppressWarnings({"checkstyle:WhitespaceAfter", "checkstyle:LineLength", "checkstyle:MissingJavadocMethod"})
    @Test
    public void findAll() {

        ApplicationUser user = new ApplicationUser("adam1", "adam1@sports.com", "12345", "0543843351", "30");
        user.setId("1234");
        user.setRole("1");
        given(userService.findById(user.getId())).willReturn(user);

        Reservation reservation = new Reservation("111", user.getId(), new Date(), new Date(), "4", "lalal", user.getName(),
                user.getUsername());
        reservation.setId("1234");
        List<Reservation> data = new ArrayList<>();
        data.add(reservation);
        given(reservationRepository.findAll()).willReturn(data);
        assertThat(reservationService.findAll(user.getId())).isEqualTo(data);

    }

    @SuppressWarnings({"checkstyle:LineLength", "checkstyle:WhitespaceAfter", "checkstyle:WhitespaceAround", "checkstyle:MissingJavadocMethod"})
    @Test
    public void checkTotalHoursBetweenStartDateAndEndDate() {
        Reservation reservation = new Reservation("111", "11", new Date(), new Date(), "4", "lalal", "adam",
                "aaaaaa");
        reservation.setId("1234");
        assertThat(reservationService.checkTotalHoursBetweenStartDateAndEndDate(reservation)).isEqualTo(false);
    }

    @SuppressWarnings({"checkstyle:WhitespaceAfter", "checkstyle:LineLength", "checkstyle:WhitespaceAround", "checkstyle:MissingJavadocMethod"})
    @Test
    public void checkIfClientHaveReservationInSameDay() {
        ApplicationUser user = new ApplicationUser("adam1", "adam1@sports.com", "12345", "0543843351", "30");
        user.setId("1234");
        user.setRole("1");
        Reservation reservation = new Reservation("111", user.getId(), new Date(), new Date(), "4", "lalal", user.getName(),
                user.getUsername());
        reservation.setId("1234");
        List<Reservation> data = new ArrayList<>();
        data.add(reservation);

        given(reservationRepository.findAll()).willReturn(data);

        assertThat(reservationService.checkIfClientHaveReservationInSameDay(user.getId(), new Date())).isEqualTo(false);
    }

}