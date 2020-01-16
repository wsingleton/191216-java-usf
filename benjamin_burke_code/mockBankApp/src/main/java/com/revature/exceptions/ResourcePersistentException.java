package com.revature.exceptions;

public class ResourcePersistentException extends RuntimeException {

    public ResourcePersistentException() {
        super("Resource not persisted");
    }

    public ResourcePersistentException(String message) {
        super(message);
    }

}
