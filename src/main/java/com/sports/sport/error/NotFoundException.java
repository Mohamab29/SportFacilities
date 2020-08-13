package com.sports.sport.error;

import org.springframework.http.HttpStatus;

/**
 * @author Adham Eldda <elddawork@gmail.com>
 * @Created 31/03/2020 12:12 PM.
 */
@SuppressWarnings("checkstyle:JavadocType")
public class NotFoundException extends ApiBaseException {

    @SuppressWarnings({"checkstyle:FinalParameters", "checkstyle:MissingJavadocMethod"})
    public NotFoundException(String message) {
        super(message);
    }

    @SuppressWarnings("checkstyle:DesignForExtension")
    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.NOT_FOUND;
    }
}
