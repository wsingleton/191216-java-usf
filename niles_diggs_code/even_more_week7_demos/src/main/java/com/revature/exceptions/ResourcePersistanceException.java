package com.revature.exceptions;

public class ResourcePersistanceException extends QuizzardException {
    public ResourcePersistanceException() {
        super("Resource could not be persisted");
    }

    public ResourcePersistanceException(String message) {
        super(message);
    }
}
