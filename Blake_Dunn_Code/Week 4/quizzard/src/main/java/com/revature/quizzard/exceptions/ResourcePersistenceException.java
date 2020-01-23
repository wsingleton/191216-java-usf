package com.revature.quizzard.exceptions;

public class ResourcePersistenceException extends RuntimeException {

    public ResourcePersistenceException() {
        super("Resource not persisted!");
    }

    public ResourcePersistenceException(String message) {
        super(message);
    }

}
