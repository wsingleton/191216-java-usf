package com.revature.revabooks.exceptions;

public class AuthorizationException extends RuntimeException {

    public AuthorizationException(){
        super("You do have the proper permissions to perform that actions!");
    }
}
