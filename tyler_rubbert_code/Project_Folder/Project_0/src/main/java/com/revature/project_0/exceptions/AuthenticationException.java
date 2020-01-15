package com.revature.project_0.exceptions;

public class AuthenticationException extends RuntimeException {

    public AuthenticationException() {
        super("Authentication Failed!");
    }

}
