package com.tg.cmd.patient.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidFamilyMemberException extends Exception {

    public InvalidFamilyMemberException(String message) {
        super(message);
    }
}
