package com.revature.quizzard.exceptions;

public class AutheticationException extends QuizzardException {

    public AutheticationException(){
        super("Bad creds");
    }
    public AutheticationException(String message){
        super(message);
    }
}
