package com.sports.sport.repository;

import com.sports.sport.reservation.Reservation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author adam
 * @created 21:23
 */
@SuppressWarnings({"checkstyle:WhitespaceAfter", "checkstyle:LineLength", "checkstyle:JavadocType"})
@Repository
public interface ReservationRepository extends MongoRepository<Reservation, String> {
    @SuppressWarnings("checkstyle:MissingJavadocMethod")
    List<Reservation> findByIdApplicationUser(String id);
//    Reservation finByStart(Date date);
//    Reservation finByEnd(Date date);
}
