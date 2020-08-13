package com.sports.sport.damage;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

/**
 * @author adam
 * @created
 */
@SuppressWarnings({"checkstyle:LineLength", "checkstyle:NoWhitespaceBefore"})
@Document(collection = "damage")
public class Damage {

    @SuppressWarnings("checkstyle:JavadocVariable")
    @Id
    private String id;

    @SuppressWarnings("checkstyle:JavadocVariable")
    @NotEmpty
    private String idAdvertisement;

    @SuppressWarnings("checkstyle:JavadocVariable")
    @NotEmpty
    private String status;

    @SuppressWarnings("checkstyle:JavadocVariable")
    @NotEmpty
    private String reason;

    @SuppressWarnings("checkstyle:JavadocVariable")
    @NotEmpty
    private String documentation;


    @SuppressWarnings("checkstyle:JavadocVariable")
    @NotEmpty
    private Date date;

    @SuppressWarnings("checkstyle:MissingJavadocMethod")
    public Damage() {
    }

    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:MissingJavadocMethod"})
    public Damage(@NotEmpty String idAdvertisement, @NotEmpty String status, @NotEmpty String reason, @NotEmpty String documentation) {
        this.idAdvertisement = idAdvertisement;
        this.status = status;
        this.reason = reason;
        this.documentation = documentation;
        this.date = new Date();
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
    public String getStatus() {
        return status;
    }

    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void setStatus(String status) {
        this.status = status;
    }

    @SuppressWarnings({"checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public String getReason() {
        return reason;
    }

    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void setReason(String reason) {
        this.reason = reason;
    }

    @SuppressWarnings({"checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public String getDocumentation() {
        return documentation;
    }

    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void setDocumentation(String documentation) {
        this.documentation = documentation;
    }

    @SuppressWarnings({"checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public Date getDate() {
        return date;
    }

    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void setDate(Date date) {
        this.date = date;
    }

    @SuppressWarnings({"checkstyle:OperatorWrap", "checkstyle:DesignForExtension"})
    @Override
    public String toString() {
        return "Complaint{" +
                "id='" + id + '\'' +
                ", idAdvertisement='" + idAdvertisement + '\'' +
                ", status='" + status + '\'' +
                ", reason='" + reason + '\'' +
                ", documentation='" + documentation + '\'' +
                ", date=" + date +
                '}';
    }
}
