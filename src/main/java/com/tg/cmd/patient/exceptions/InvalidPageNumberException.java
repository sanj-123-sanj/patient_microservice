package com.tg.cmd.patient.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)  // Customize with the appropriate status
public class InvalidPageNumberException extends Exception {

    public InvalidPageNumberException() {
        super();
    }

    public InvalidPageNumberException(String message) {
        super(message);
    }

    public InvalidPageNumberException(String message, Throwable cause) {
        super(message, cause);
    }
}
