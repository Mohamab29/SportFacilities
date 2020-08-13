package com.sports.sport.controllers;

import com.sports.sport.reservation.Reservation;
import com.sports.sport.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;

/**
 * @author adam
 * @created 17:38
 */
@SuppressWarnings("checkstyle:JavadocType")
@RestController
@CrossOrigin
@RequestMapping("/Reservation")
public class ReservationController {

    @SuppressWarnings("checkstyle:JavadocVariable")
    @Autowired
    private ReservationService reservationService;

    //PM2020T25-179
    //Build Rest api -Back end - client I can cancel the reservations I made
    @SuppressWarnings({"checkstyle:FinalParameters", "checkstyle:LineLength", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    @PostMapping("/addReservation")
    public String addReservation(@RequestBody Reservation reservation) throws MessagingException {

        return reservationService.addReservation(reservation);
    }

    //Build Rest api -Back end -client I can view the sport facilities
    //PM2020T25-178
    //Build Rest api -Back end -Client I can see the reservations I made in labels
    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod", "checkstyle:LineLength"})
    @GetMapping("/getListReservationById/{id}")
    public List<Reservation> getListReservationById(@PathVariable String id) {

        return reservationService.findAll(id);
    }

    //PM2020T25-177
    //Build Rest api -Back end - admin I can decline a reservation by using the decline button on the reservation label
    @SuppressWarnings({"checkstyle:FinalParameters", "checkstyle:LineLength", "checkstyle:WhitespaceAround", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    @DeleteMapping(path = "{id}")
    public String deleteReservation(@PathVariable String id) throws MessagingException {

        return reservationService.deleteById(id);
    }

}
