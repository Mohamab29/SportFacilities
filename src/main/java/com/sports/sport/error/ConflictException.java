package com.sports.sport.error;

import org.springframework.http.HttpStatus;

/**
 * @author Adham Eldda <elddawork@gmail.com>
 * @Created 31/03/2020 11:45 PM.
 */
@SuppressWarnings("checkstyle:JavadocType")
public class ConflictException extends ApiBaseException {

    @SuppressWarnings({"checkstyle:FinalParameters", "checkstyle:MissingJavadocMethod"})
    public ConflictException(String message) {
        super(message);
    }

    @SuppressWarnings("checkstyle:DesignForExtension")
    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.CONFLICT;
    }
}
