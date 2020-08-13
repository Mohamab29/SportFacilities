package com.sports.sport.service;

import com.sports.sport.ad.Advertisement;
import com.sports.sport.message.SendEmail;
import com.sports.sport.repository.ReservationRepository;
import com.sports.sport.reservation.Reservation;
import com.sports.sport.security.UserService;
import com.sports.sport.security.userDetails.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.Date;
import java.util.List;

/**
 * @author adam
 * @created 21:23
 */
@SuppressWarnings({"checkstyle:LineLength", "checkstyle:JavadocType"})
@Service
public class ReservationService {

    @SuppressWarnings("checkstyle:JavadocVariable")
    @Autowired
    private ReservationRepository reservationRepository;

    @SuppressWarnings("checkstyle:JavadocVariable")
    @Autowired
    private AdvertisementService advertisementService;

    @SuppressWarnings("checkstyle:JavadocVariable")
    @Autowired
    private UserService userService;

    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:LineLength", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public String deleteById(String id) throws MessagingException {

        if (reservationRepository.existsById(id)) {
            Reservation reservation = reservationRepository.findById(id).get();
            ApplicationUser applicationUser = userService.findById(reservation.getIdApplicationUser());
            SendEmail.sendMail(applicationUser.getUsername(),
                    "Info Sports facilities" + reservation.getReservationNumber(),
                    "BeerSheva , Admin Sports facilities delete your Reservation number" + reservation.getReservationNumber() + " Thank You , \n GOOD DAY");
            reservationRepository.deleteById(id);
            return id + " : Deleted";
        } else {
            return id + " : not found";
        }
    }

    //PM2020T25-180
    //Build Rest api -Back end -client I can make a reservation for a specific sport facility
    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:WhitespaceAfter", "checkstyle:LineLength", "checkstyle:MagicNumber", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public String addReservation(Reservation reservation) throws MessagingException {

        if (advertisementService.checkAdvertisementAvailable(reservation.getIdAdvertisement())
                && this.checkTotalHoursBetweenStartDateAndEndDate(reservation)
                && this.checkIfClientHaveReservationInSameDay(reservation.getIdApplicationUser(), reservation.getStart())
                && this.checkIfHaveSameReservationForOtherUsers(reservation)
                && Integer.parseInt(reservation.getNumberTeam()) >= 4 && Integer.parseInt(reservation.getNumberTeam()) <= 100
                && advertisementService.existsById(reservation.getIdAdvertisement())
                && userService.existsById(reservation.getIdApplicationUser())) {
            ApplicationUser applicationUser = userService.findById(reservation.getIdApplicationUser());
            Advertisement advertisement = advertisementService.findById(reservation.getIdAdvertisement());
            reservation.setNameApplicationUser(applicationUser.getName());
            reservation.setEmailApplicationUser(applicationUser.getUsername());
            reservation.setNameAdvertisement(advertisement.getName());
            reservation.setCreated(new Date());
            reservation.setReservationNumber();
            //PM2020T25-181
            //Build Rest api -Back end -client I can make a reservation for a specific sport facility
            reservationRepository.save(reservation);
            SendEmail.sendMail(reservation.getEmailApplicationUser(), "תודה שהזמנת מתקן : " + advertisement.getName(), "תודה שבחרתה לשחק בעיר באר שבע - תהנה ");
            return "Your Reservation Accept !";
        } else {
            return "Your Reservation Reject!";
        }
    }

    //All below methods for check Date and Time before add Reservation
    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:LineLength", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public boolean checkIfClientHaveReservationInSameDay(String idIdApplicationUser, Date date) {

        List<Reservation> list = reservationRepository.findAll();

        for (Reservation res : list
        ) {
            if (res.getStart().getDay() == date.getDay() && res.getStart().getYear() == date.getYear() && res.getStart().getMonth() == date.getMonth() && res.getIdApplicationUser().equals(idIdApplicationUser)) {
                return false;
            }
        }
        return true;

    }

    //check limit time between start reservation and end reservation
    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:MagicNumber", "checkstyle:SimplifyBooleanReturn", "checkstyle:LineLength", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public boolean checkTotalHoursBetweenStartDateAndEndDate(Reservation reservation) {

        long diff = reservation.getStart().getTime() - reservation.getEnd().getTime();
        long diffHours = Math.abs(diff / (60 * 60 * 1000) % 24); //if the different <0
        return diffHours <= 4 && diffHours >= 1;
    }

    //find all By Role User and get All  Reservation
    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public List<Reservation> findAll(String id) {

        ApplicationUser user = userService.findById(id);
        if (user == null) {
            return null;
        }
        if (user.getRole().equals("1") || user.getRole().equals("2")) {

            return reservationRepository.findAll();

        }
        if (user.getRole().equals("3")) {

            return reservationRepository.findByIdApplicationUser(id);
        }

        return null;

    }

    //check conflict between new Reservation and other  reservations from database
    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:LineLength", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public boolean checkIfHaveSameReservationForOtherUsers(Reservation reservation) {

        List<Reservation> list = reservationRepository.findAll();

        for (Reservation res : list
        ) {
            if (reservation.getEnd().after(res.getStart()) && reservation.getEnd().before(res.getEnd())) {
                return false;
            }
            if (reservation.getStart().after(res.getStart()) && reservation.getStart().before(res.getEnd())) {
                return false;
            }
            if (reservation.getStart().compareTo(res.getStart()) == 0) {

                return false;
            }
            if (res.getStart().after(reservation.getStart()) && res.getEnd().before(reservation.getEnd())) {

                return false;

            }

        }
        return true;
    }

}
