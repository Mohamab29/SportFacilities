package com.sports.sport.error;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Adham Eldda <elddawork@gmail.com>
 * @Created 31/03/2020 09:55 PM.
 */
@SuppressWarnings({"checkstyle:LineLength", "checkstyle:JavadocType"})
public class ValidationError {

    @SuppressWarnings("checkstyle:JavadocVariable")
    private List<String> errors;

    @SuppressWarnings("checkstyle:JavadocVariable")
    private String uri;


    @SuppressWarnings("checkstyle:JavadocVariable")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date timestamp;

    @SuppressWarnings("checkstyle:MissingJavadocMethod")
    public ValidationError() {
        this.timestamp = new Date();
        this.errors = new ArrayList<>();
    }

    @SuppressWarnings({"checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void addError(String error) {
        this.errors.add(error);
    }

    @SuppressWarnings({"checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public List<String> getErrors() {
        return errors;
    }

    @SuppressWarnings({"checkstyle:HiddenField", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    public void setErrors(List<String> errors) {
        this.errors = errors;
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
