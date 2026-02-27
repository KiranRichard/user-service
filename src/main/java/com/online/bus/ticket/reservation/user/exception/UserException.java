package com.online.bus.ticket.reservation.user.exception;

public class UserException extends RuntimeException {

    private String errorMessage;

    public UserException() {
        super();
    }

    public UserException(String errorMessage) {
        super(errorMessage);
    }
}
