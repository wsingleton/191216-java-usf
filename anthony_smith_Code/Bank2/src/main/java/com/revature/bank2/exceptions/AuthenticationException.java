package com.revature.bank2.exceptions;

public class AuthenticationException extends  RuntimeException {
    public AuthenticationException(){
        super("Authentication failed!");

    }

}
