package com.revature.exceptions;

public class AuthorizationException extends NiceException {

    public  AuthorizationException() {
        super("Not Authorized!");
    }

    public AuthorizationException(String message) {
        super(message);
    }
}
