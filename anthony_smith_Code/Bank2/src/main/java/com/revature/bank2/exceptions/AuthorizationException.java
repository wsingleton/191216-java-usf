package com.revature.bank2.exceptions;

public class AuthorizationException extends RuntimeException {

    public AuthorizationException(){
        super("You do not have the proper permissions to perform that action!");
    }

}
