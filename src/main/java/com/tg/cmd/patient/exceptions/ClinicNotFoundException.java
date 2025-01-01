package com.tg.cmd.patient.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ClinicNotFoundException extends Exception {

    public ClinicNotFoundException(String message) {
        super(message);
    }
}
