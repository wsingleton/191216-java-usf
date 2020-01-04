package com.revature.revabooks.exceptions;

public class ResourcePersistanceException extends RuntimeException {

    public ResourcePersistanceException() {
        super("Resource not persisted!");
    }

    public ResourcePersistanceException(String message) {
        super(message);
    }
}
