package com.revature.exceptions;

public class AuthenticationException extends QuizzardException {
    public AuthenticationException() {
        super("Invalid credentials given!");
    }

    public AuthenticationException(String message) {
        super(message);
    }
}
