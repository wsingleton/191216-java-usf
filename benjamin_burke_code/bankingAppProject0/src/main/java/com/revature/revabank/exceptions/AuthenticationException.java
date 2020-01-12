package com.revature.revabank.exceptions;

public class AuthenticationException extends RuntimeException {

    public AuthenticationException(){
        super("Authentication failed");
    }
}
