package com.revature.exceptions;

public class AuthenticationException extends RuntimeException {

    public  AuthenticationException() {
        super("authentication failed");
    }
}
