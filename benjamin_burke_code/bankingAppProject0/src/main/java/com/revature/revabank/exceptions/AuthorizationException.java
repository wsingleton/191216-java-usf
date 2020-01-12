package com.revature.revabank.exceptions;

public class AuthorizationException extends RuntimeException {

    public AuthorizationException(){
        super("You do not have the proper permission to perform this action!");
    }
}
