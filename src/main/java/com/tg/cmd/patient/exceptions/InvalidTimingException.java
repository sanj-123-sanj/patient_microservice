package com.tg.cmd.patient.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)  // Customize with the appropriate status
public class InvalidTimingException extends Exception {

    public InvalidTimingException(String message) {
        super(message);
    }
}

