package com.revature.spring.exceptions;

public class AuthenticationException extends SpringProjectException {

    public AuthenticationException() {
        super("Authentication failed!");
    }
}
