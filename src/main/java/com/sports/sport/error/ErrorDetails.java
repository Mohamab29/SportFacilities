package com.sports.sport.error;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author Adham Eldda <elddawork@gmail.com>
 * @Created 31/03/2020 10:47 PM.
 */
@SuppressWarnings({"checkstyle:LineLength", "checkstyle:JavadocType"})
public class ErrorDetails {

    @SuppressWarnings("checkstyle:JavadocVariable")
    private String message;

    @SuppressWarnings("checkstyle:JavadocVariable")
    private String uri;

    @SuppressWarnings("checkstyle:JavadocVariable")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date timestamp;

    @SuppressWarnings("checkstyle:MissingJavadocMethod")
    public ErrorDetails() {
        this.timestamp = new Date();
    }


    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:MissingJavadocMethod"})
    public ErrorDetails(String message, String uri) {
        this();
        this.message = message;
        this.uri = uri;
    }

    @SuppressWarnings({"checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public String getMessage() {
        return message;
    }

    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void setMessage(String message) {
        this.message = message;
    }

    @SuppressWarnings({"checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public String getUri() {
        return uri;
    }

    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void setUri(String uri) {
        this.uri = uri;
    }

    @SuppressWarnings({"checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public Date getTimestamp() {
        return timestamp;
    }

    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
