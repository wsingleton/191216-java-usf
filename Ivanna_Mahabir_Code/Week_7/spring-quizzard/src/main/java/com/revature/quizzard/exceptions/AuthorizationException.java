package com.revature.quizzard.exceptions;

public class AuthorizationException extends QuizzardException {

    public AuthorizationException(){
        super("No Authorization");
    }

    public AuthorizationException(String message) {
        super(message);
    }
}
