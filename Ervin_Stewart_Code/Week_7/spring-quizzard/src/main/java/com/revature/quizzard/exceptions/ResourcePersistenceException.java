package com.revature.quizzard.exceptions;

public class ResourcePersistenceException extends QuizzardException {
    public ResourcePersistenceException(String message) {
        super(message);
    }

    public ResourcePersistenceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourcePersistenceException() {
        super("Resource could not be persisted!");
    }
}
