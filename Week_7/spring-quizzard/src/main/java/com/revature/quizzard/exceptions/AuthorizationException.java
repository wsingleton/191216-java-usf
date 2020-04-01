package com.revature.quizzard.exceptions;

public class AuthorizationException extends QuizzardException {

    public AuthorizationException() {
        super("Requester lacks the proper authorities to perform that action!x");
    }

    public AuthorizationException(String message) {
        super(message);
    }
}
