package com.sports.sport.reservation;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

/**
 * @author adam
 * @created 21:15
 */

@SuppressWarnings({"checkstyle:LineLength", "checkstyle:WhitespaceAround", "checkstyle:NoWhitespaceBefore", "checkstyle:JavadocType"})
@Document(collection = "reservation")
public class Reservation {
    //validation
    @SuppressWarnings("checkstyle:JavadocVariable")
    @Id
    private String id;

    @SuppressWarnings("checkstyle:JavadocVariable")
    @NotEmpty
    private String idAdvertisement;


    @SuppressWarnings("checkstyle:JavadocVariable")
    @NotEmpty
    private String nameAdvertisement;

    @SuppressWarnings("checkstyle:JavadocVariable")
    @NotEmpty
    private String idApplicationUser;

    @SuppressWarnings("checkstyle:JavadocVariable")
    @NotEmpty
    private String nameApplicationUser;

    @SuppressWarnings("checkstyle:JavadocVariable")
    @NotEmpty
    private String emailApplicationUser;

    @SuppressWarnings("checkstyle:JavadocVariable")
    @NotEmpty
    private Date start;

    @SuppressWarnings("checkstyle:JavadocVariable")
    @NotEmpty
    private Date end;

    @SuppressWarnings("checkstyle:JavadocVariable")
    @NotEmpty
    private String numberTeam;


    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:JavadocVariable"})
    private String reservationNumber = "0";
    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:JavadocVariable"})
    private static int number = 0;

    @SuppressWarnings("checkstyle:JavadocVariable")
    @NotEmpty
    private Date created;

    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:MissingJavadocMethod"})
    public Reservation() {
    }

    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:ParenPad", "checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:NoWhitespaceBefore", "checkstyle:WhitespaceAfter", "checkstyle:ParameterNumber", "checkstyle:MissingJavadocMethod"})
    public Reservation(@NotEmpty String idAdvertisement, @NotEmpty String idApplicationUser, @NotEmpty Date start, @NotEmpty Date end, @NotEmpty String numberTeam, @NotEmpty String nameAdvertisement, @NotEmpty String nameApplicationUser, @NotEmpty String emailApplicationUser) {
        this.idAdvertisement = idAdvertisement;
        this.idApplicationUser = idApplicationUser;
        this.start = start;
        this.end = end;
        this.numberTeam = numberTeam;
        this.created = new Date();
        this.nameAdvertisement = nameAdvertisement;
        this.nameApplicationUser = nameApplicationUser;
        this.emailApplicationUser = emailApplicationUser;
        number++;
        Integer.toString(number);
        reservationNumber = Integer.toString(number);
    }

    @SuppressWarnings({"checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public String getId() {
        return id;
    }

    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void setId(String id) {
        this.id = id;
    }

    @SuppressWarnings({"checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public String getIdAdvertisement() {
        return idAdvertisement;
    }

    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void setIdAdvertisement(String idAdvertisement) {
        this.idAdvertisement = idAdvertisement;
    }

    @SuppressWarnings({"checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public String getIdApplicationUser() {
        return idApplicationUser;
    }

    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void setIdApplicationUser(String idApplicationUser) {
        this.idApplicationUser = idApplicationUser;
    }

    @SuppressWarnings({"checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public Date getStart() {
        return start;
    }

    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void setStart(Date start) {
        this.start = start;
    }

    @SuppressWarnings({"checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public Date getEnd() {
        return end;
    }

    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void setEnd(Date end) {
        this.end = end;
    }

    @SuppressWarnings({"checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public Date getCreated() {
        return created;
    }

    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void setCreated(Date created) {
        this.created = created;
    }

    @SuppressWarnings({"checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public String getReservationNumber() {
        return reservationNumber;
    }

    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void setReservationNumber() {
        number++;
        Integer.toString(number);
        reservationNumber = Integer.toString(number);
    }

    @SuppressWarnings({"checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public String getNameAdvertisement() {
        return nameAdvertisement;
    }

    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void setNameAdvertisement(String nameAdvertisement) {
        this.nameAdvertisement = nameAdvertisement;
    }

    @SuppressWarnings({"checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public String getNumberTeam() {
        return numberTeam;
    }

    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void setNumberTeam(String numberTeam) {
        this.numberTeam = numberTeam;
    }

    @SuppressWarnings({"checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public String getNameApplicationUser() {
        return nameApplicationUser;
    }

    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void setNameApplicationUser(String nameApplicationUser) {
        this.nameApplicationUser = nameApplicationUser;
    }

    @SuppressWarnings({"checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public String getEmailApplicationUser() {
        return emailApplicationUser;
    }

    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void setEmailApplicationUser(String emailApplicationUser) {
        this.emailApplicationUser = emailApplicationUser;
    }

    @SuppressWarnings({"checkstyle:OperatorWrap", "checkstyle:DesignForExtension"})
    @Override
    public String toString() {
        return "Reservation{" +
                "id='" + id + '\'' +
                ", idAdvertisement='" + idAdvertisement + '\'' +
                ", nameAdvertisement='" + nameAdvertisement + '\'' +
                ", idApplicationUser='" + idApplicationUser + '\'' +
                ", nameApplicationUser='" + nameApplicationUser + '\'' +
                ", emailApplicationUser='" + emailApplicationUser + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", numberTeam='" + numberTeam + '\'' +
                ", reservationNumber='" + reservationNumber + '\'' +
                ", created=" + created +
                '}';
    }
}
