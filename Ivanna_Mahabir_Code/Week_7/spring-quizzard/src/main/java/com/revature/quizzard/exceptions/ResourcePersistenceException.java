package com.revature.quizzard.exceptions;

public class ResourcePersistenceException extends QuizzardException {

    public ResourcePersistenceException(){
        super("No resource Persistence");
    }

    public ResourcePersistenceException(String message) {
        super(message);
    }
}
