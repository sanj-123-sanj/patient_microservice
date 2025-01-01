package com.tg.cmd.patient.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)  // You can adjust the status code as needed
public class PreferredClinicNotAvailableException extends Exception {

    public PreferredClinicNotAvailableException(String message) {
        super(message);
    }
}

