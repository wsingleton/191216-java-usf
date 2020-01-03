package com.revature.revabooks.exceptions;

public class AuthenticatironException extends RuntimeException {

    public AuthenticatironException() {
        super("Authentication Failed");
    }
}
