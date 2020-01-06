package com.revature.revabooks.exceptions;

public class AuthorizationException extends RuntimeException {

    public AuthorizationException() {
        super("Authorization error!");
    }
}
