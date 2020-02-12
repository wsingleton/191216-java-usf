package com.revature.quizzard.exceptions;

public class AuthorizationException extends QuizzardException {

    public AuthorizationException() {
        super("Requester lacks the valid authorities to perform that action!");
    }

    public AuthorizationException(String message) {
        super(message);
    }
}
