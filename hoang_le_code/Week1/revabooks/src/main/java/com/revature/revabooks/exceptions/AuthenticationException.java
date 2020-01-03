package com.revature.revabooks.exceptions;

public class AuthenticationException extends RuntimeException {
    public AuthenticationException() {
        super("You do not have the proper permissions to perform that action! ");
    }


}