package com.sports.sport.error;

import org.springframework.http.HttpStatus;

/**
 * @author Adham Eldda <elddawork@gmail.com>
 * @Created 31/03/2020 10:45 PM.
 */
@SuppressWarnings("checkstyle:JavadocType")
public abstract class ApiBaseException extends RuntimeException {

    @SuppressWarnings({"checkstyle:FinalParameters", "checkstyle:MissingJavadocMethod"})
    public ApiBaseException(String message) {
        super(message);
    }

    @SuppressWarnings("checkstyle:MissingJavadocMethod")
    public abstract HttpStatus getStatusCode();
}
