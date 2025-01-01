package com.tg.cmd.patient.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidEmergencyContactException extends Exception {

    public InvalidEmergencyContactException() {
        super();
    }

    public InvalidEmergencyContactException(String message) {
        super(message);
    }

    public InvalidEmergencyContactException(String message, Throwable cause) {
        super(message, cause);
    }
}
