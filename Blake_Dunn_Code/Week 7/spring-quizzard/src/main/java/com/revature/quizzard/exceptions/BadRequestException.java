package com.revature.quizzard.exceptions;

public class BadRequestException extends QuizzardException {

    public BadRequestException() {
        super("Bad request ");
    }

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
