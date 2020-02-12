package com.revature.quizzard.exceptions;

public class AuthorizationException extends QuizzardException {
    public AuthorizationException() {
        super("User unauthorized to take requested action");
    }
    public AuthorizationException(String msg) {
        super(msg);
    }
}
