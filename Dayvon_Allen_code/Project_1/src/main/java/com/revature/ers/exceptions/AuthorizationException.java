package com.revature.ers.exceptions;

public class AuthorizationException extends RuntimeException {
    public AuthorizationException() {
        super("You do not have the proper permissions to perform that action!");
    }

}

