package com.revature.demos.exceptions;

public class AuthenticationException extends QuizzardException {
    public AuthenticationException() {
        super("Invalid credentials given!");
    }

    public AuthenticationException(String message) {
        super(message);
    }
}
