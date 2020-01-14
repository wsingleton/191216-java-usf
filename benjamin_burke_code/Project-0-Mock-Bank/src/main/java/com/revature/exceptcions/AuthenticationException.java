package com.revature.exceptcions;

public class AuthenticationException extends RuntimeException {
    public AuthenticationException(){
        super("You do not have the proper permissions to perform this action!");
    }
}
