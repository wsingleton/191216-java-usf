package com.revature.exceptions;

public class AuthenticationException extends NiceException {

    public  AuthenticationException() {
        super("Authentication Failed!");
    }

    public AuthenticationException(String message) {
        super(message);
    }
}
