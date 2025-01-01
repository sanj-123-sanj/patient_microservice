package com.tg.cmd.patient.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)  // You can adjust the status code as needed
public class InvalidClinicSlotTimingsException extends Exception {

    public InvalidClinicSlotTimingsException(String message) {
        super(message);
    }
}



