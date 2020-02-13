package com.revature.quizzard.exceptions;

public class BadRequestException extends QuizzardException {

    public BadRequestException() {
        super("An invalid request was made!");
    }

    public BadRequestException(String message) {
        super(message);
    }

}
