package com.revature.exceptions;

public class BadRequestException extends QuizzardException {
    public BadRequestException() {
        super("The requested action does not exist");
    }

    public BadRequestException(String message) {
        super(message);
    }
}
