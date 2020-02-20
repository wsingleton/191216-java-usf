package com.revature.quizzard.exceptions;

public class AuthenticationException extends QuizzardException {

    public AuthenticationException() {
        super("Invalid username or password");
    }

    public AuthenticationException(String message) {
        super(message);
    }

    public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}
