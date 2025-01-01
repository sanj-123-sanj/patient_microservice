package com.tg.cmd.patient.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidDateOfBirthException extends Exception {

    public InvalidDateOfBirthException() {
        super();
    }

    public InvalidDateOfBirthException(String message) {
        super(message);
    }

    public InvalidDateOfBirthException(String message, Throwable cause) {
        super(message, cause);
    }
}


