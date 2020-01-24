package com.revature.mockERS.exceptions;

public class AuthenticationException extends RuntimeException {
    public AuthenticationException(){
        super("Authentication failed!");
    }
}
