package com.revature.demos.exceptions;

public class AuthorizationException extends QuizzardException {
    public AuthorizationException() {
        super("You lack the privileges to perform this action");
    }

    public AuthorizationException(String message) {
        super(message);
    }
}
