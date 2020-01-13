package com.revature.bankapp.exceptions;

public class AuthenticationException extends RuntimeException {

    public AuthenticationException() {
        super("Invalid Credentials");
    }
}
