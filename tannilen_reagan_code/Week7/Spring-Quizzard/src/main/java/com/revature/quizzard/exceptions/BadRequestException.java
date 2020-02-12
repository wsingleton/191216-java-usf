package com.revature.quizzard.exceptions;

public class BadRequestException extends QuizzardException {
    public BadRequestException() {
        super("Invalid request");
    }
    public BadRequestException(String msg) {
        super(msg);
    }
}
