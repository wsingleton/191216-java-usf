package com.revature.project_0.exceptions;

public class AuthorizationException extends RuntimeException {

    public AuthorizationException() {
        super("You do not have permission to perform that action!");
    }

}
