package com.revature.expections;

public class AuthenticationException extends RuntimeException {

    public AuthenticationException() {
        super("Authentication failed!");
    }

}