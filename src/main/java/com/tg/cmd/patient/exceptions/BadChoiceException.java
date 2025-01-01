package com.tg.cmd.patient.exceptions;

	public class BadChoiceException extends Exception {

	    /**
	     * Constructs a new BadChoiceException with the specified detail message.
	     *
	     * @param message the detail message explaining the reason for the exception
	     */
	    public BadChoiceException(String message) {
	        super(message);
	    }

	    /**
	     * Constructs a new BadChoiceException with the specified detail message and cause.
	     *
	     * @param message the detail message explaining the reason for the exception
	     * @param cause the cause of the exception (a throwable object)
	     */
	    public BadChoiceException(String message, Throwable cause) {
	        super(message, cause);
	    }
	}


