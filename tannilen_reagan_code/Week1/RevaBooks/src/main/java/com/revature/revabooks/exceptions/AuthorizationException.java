package com.revature.revabooks.exceptions;

public class AuthorizationException extends RuntimeException {
    public AuthorizationException() {
        super("You do not have the permissions to perform that action.");
    }
}
