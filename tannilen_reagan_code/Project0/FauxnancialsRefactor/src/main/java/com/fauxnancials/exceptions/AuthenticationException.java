package com.fauxnancials.exceptions;

public class AuthenticationException extends RuntimeException {
    public AuthenticationException() {
        super("Invalid username or password.  Authentication failed.");
    }
}
