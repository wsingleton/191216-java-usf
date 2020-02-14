package com.revature.quizzard.exceptions;

public class AuthenticationException extends QuizzardException {
    public AuthenticationException(){
        super("Authenication failed!");
    }

    public AuthenticationException(String message){
        super(message);
    }
}
