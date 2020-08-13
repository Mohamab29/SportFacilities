package com.sports.sport.message;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

/**
 * @author adam
 * @created
 */
@SuppressWarnings({"checkstyle:LineLength", "checkstyle:NoWhitespaceBefore"})
@Document(collection = "email")
public class Message {

    @SuppressWarnings("checkstyle:JavadocVariable")
    @Id
    private String id;

    @SuppressWarnings("checkstyle:JavadocVariable")
    @NotEmpty
    private String idUser;

    @SuppressWarnings("checkstyle:JavadocVariable")
    @NotEmpty
    private String userNameSending;

    @SuppressWarnings("checkstyle:JavadocVariable")
    @NotEmpty
    private String recipientEmail;

    @SuppressWarnings("checkstyle:JavadocVariable")
    @NotEmpty
    private String subject;

    @SuppressWarnings("checkstyle:JavadocVariable")
    @NotEmpty
    private String body;

    @SuppressWarnings("checkstyle:MissingJavadocMethod")
    @NotEmpty
    public Message() {
    }

    @SuppressWarnings({"checkstyle:VisibilityModifier", "checkstyle:JavadocVariable"})
    @NotEmpty
    public Date created;


    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:MissingJavadocMethod"})
    public Message(@NotEmpty String idUser, @NotEmpty String userNameSending, @NotEmpty String recipientEmail, @NotEmpty String subject, @NotEmpty String body) {
        this.idUser = idUser;
        this.userNameSending = userNameSending;
        this.recipientEmail = recipientEmail;
        this.subject = subject;
        this.body = body;
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
    public String getIdUser() {
        return idUser;
    }

    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    @SuppressWarnings({"checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public String getUserNameSending() {
        return userNameSending;
    }

    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void setUserNameSending(String userNameSending) {
        this.userNameSending = userNameSending;
    }

    @SuppressWarnings({"checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public String getRecipientEmail() {
        return recipientEmail;
    }

    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void setRecipientEmail(String recipientEmail) {
        this.recipientEmail = recipientEmail;
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
    public Date getCreated() {
        return created;
    }

    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void setCreated(Date created) {
        this.created = created;
    }

    @SuppressWarnings({"checkstyle:OperatorWrap", "checkstyle:DesignForExtension"})
    @Override
    public String toString() {
        return "Message{" +
                "id='" + id + '\'' +
                ", idUser='" + idUser + '\'' +
                ", userNameSending='" + userNameSending + '\'' +
                ", recipientEmail='" + recipientEmail + '\'' +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                ", created=" + created +
                '}';
    }
}
