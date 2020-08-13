package com.sports.sport.error;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

/**
 * @author Adham Eldda <elddawork@gmail.com>
 * @Created 31/03/2020 10:41 PM.
 */
@SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:JavadocType"})
@ControllerAdvice
public class ApiExceptionsHandler extends ResponseEntityExceptionHandler {

    @SuppressWarnings({"checkstyle:LineLength", "checkstyle:WhitespaceAround", "checkstyle:FinalParameters", "checkstyle:DesignForExtension", "checkstyle:MissingJavadocMethod"})
    @ExceptionHandler(ApiBaseException.class)
    public ResponseEntity<ErrorDetails> handleApiExceptions(ApiBaseException ex, WebRequest request) {
        ErrorDetails details = new ErrorDetails(ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(details, ex.getStatusCode());
    }

    @SuppressWarnings({"checkstyle:WhitespaceAround", "checkstyle:FinalParameters", "checkstyle:LineLength", "checkstyle:DesignForExtension"})
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ValidationError validationError = new ValidationError();
        validationError.setUri(request.getDescription(false));

        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();

        for (FieldError f : fieldErrors) {
            validationError.addError(f.getDefaultMessage());
        }


        return new ResponseEntity<>(validationError, HttpStatus.BAD_REQUEST);
    }
}
