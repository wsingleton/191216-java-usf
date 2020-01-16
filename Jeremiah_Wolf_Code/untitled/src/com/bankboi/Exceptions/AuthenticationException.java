package com.bankboi.Exceptions;

public class AuthenticationException extends RuntimeException {

    public AuthenticationException() {
        super("Could not Authenticate");
    }

}