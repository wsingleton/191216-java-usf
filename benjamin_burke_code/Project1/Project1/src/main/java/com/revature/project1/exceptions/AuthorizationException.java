package com.revature.project1.exceptions;

public class AuthorizationException extends RuntimeException {
    public AuthorizationException(){
        super("You do not have permission for this action!");
    }
}
