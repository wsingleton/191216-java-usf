package com.revature.quizzard.exceptions;

public class AuthorizationException extends QuizzardException {

    public AuthorizationException(){
        super("not user");
    }
    public AuthorizationException(String message){
        super(message);
    }
}
