package com.revature.quizzard.exceptions;

public class AuthenticationException extends QuizzardException {
    public AuthenticationException() {
        super("Unable to validate credentials");
    }
    public AuthenticationException(String msg) {
        super(msg);
    }
}
