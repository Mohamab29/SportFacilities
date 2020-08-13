package com.sports.sport.complaint;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

/**
 * @author adam
 * @created 18:57
 */
@SuppressWarnings({"checkstyle:LineLength", "checkstyle:WhitespaceAround", "checkstyle:JavadocType"})
@Document(collection = "complaint")
public class Complaint {


    @SuppressWarnings("checkstyle:JavadocVariable")
    @Id
    private String id;

    @SuppressWarnings("checkstyle:JavadocVariable")
    @NotEmpty
    private String idUser;


    @SuppressWarnings("checkstyle:JavadocVariable")
    @NotEmpty
    private String userName;

    @SuppressWarnings("checkstyle:JavadocVariable")
    @NotEmpty
    private String subject;

    @SuppressWarnings("checkstyle:JavadocVariable")
    @NotEmpty
    private String body;

    @SuppressWarnings("checkstyle:JavadocVariable")
    @NotEmpty
    private String status;

    @SuppressWarnings("checkstyle:JavadocVariable")
    @NotEmpty
    private String responseAdmin;


    @SuppressWarnings("checkstyle:JavadocVariable")
    @NotEmpty
    private Date created;

    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:MissingJavadocMethod"})
    public Complaint() {
    }

    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:MissingJavadocMethod"})
    public Complaint(@NotEmpty String idUser, @NotEmpty String userName, @NotEmpty String subject, @NotEmpty String body, @NotEmpty String status, @NotEmpty String responseAdmin) {
        this.idUser = idUser;
        this.userName = userName;
        this.subject = subject;
        this.body = body;
        this.status = status;
        this.responseAdmin = responseAdmin;
        this.created = new Date();
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
    public String getSubject() {
        return subject;
    }

    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void setSubject(String subject) {
        this.subject = subject;
    }

    @SuppressWarnings({"checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public String getBody() {
        return body;
    }

    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void setBody(String body) {
        this.body = body;
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
    public String getResponseAdmin() {
        return responseAdmin;
    }

    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void setResponseAdmin(String responseAdmin) {
        this.responseAdmin = responseAdmin;
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
    public String getIdUser() {
        return idUser;
    }

    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    @SuppressWarnings({"checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public String getUserName() {
        return userName;
    }

    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @SuppressWarnings({"checkstyle:OperatorWrap", "checkstyle:DesignForExtension"})
    @Override
    public String toString() {
        return "Complaint{" +
                "id='" + id + '\'' +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                ", status='" + status + '\'' +
                ", responseAdmin='" + responseAdmin + '\'' +
                ", created=" + created +
                '}';
    }
}
