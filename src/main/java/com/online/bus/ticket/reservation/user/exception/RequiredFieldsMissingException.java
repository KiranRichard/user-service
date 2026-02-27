package com.online.bus.ticket.reservation.user.exception;

public class RequiredFieldsMissingException extends RuntimeException {

    private String errorMessage;

    public RequiredFieldsMissingException() {
        super();
    }

    public RequiredFieldsMissingException(String errorMessage) {
        super(errorMessage);
    }
}
