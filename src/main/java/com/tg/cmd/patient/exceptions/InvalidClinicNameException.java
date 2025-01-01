package com.tg.cmd.patient.exceptions;
	import org.springframework.http.HttpStatus;
	import org.springframework.web.bind.annotation.ResponseStatus;

	@ResponseStatus(HttpStatus.BAD_REQUEST)  // You can adjust the status code as needed
	public class InvalidClinicNameException extends Exception {

	    public InvalidClinicNameException(String message) {
	        super(message);
	    }
	}

