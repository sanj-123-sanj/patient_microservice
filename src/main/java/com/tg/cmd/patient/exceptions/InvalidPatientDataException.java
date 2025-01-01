package com.tg.cmd.patient.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)  // You can adjust the status code as needed
public class InvalidPatientDataException extends Exception {

    public InvalidPatientDataException(String message) {
        super(message);
    }
}

