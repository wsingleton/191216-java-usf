package com.revature.exception;

public class BadRequestException extends QuizzardException {

    public BadRequestException() {
        super("An invalid request was made!");
    }

    public BadRequestException(String message) {
        super(message);
    }

}
