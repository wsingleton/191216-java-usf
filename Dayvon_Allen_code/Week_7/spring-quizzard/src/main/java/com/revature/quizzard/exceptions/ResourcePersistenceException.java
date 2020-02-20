package com.revature.quizzard.exceptions;

public class ResourcePersistenceException extends QuizzardException {
    public ResourcePersistenceException(){
        super("Bad data");
    }
    public ResourcePersistenceException(String message){
        super(message);
    }
}
