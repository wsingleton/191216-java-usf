package com.revature.quizzard.exceptions;

public class BadRequestException extends QuizzardException {

    public BadRequestException(){
        super("Bad Request");
    }

    public BadRequestException(String message) {
        super(message);
    }
}
