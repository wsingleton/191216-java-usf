package com.bankboi.Exceptions;

public class AuthorizationException extends RuntimeException {

    public AuthorizationException() {
        super("Cannot Access upgrade account");
    }

}
