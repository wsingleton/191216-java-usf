package com.revature.revabooks.exceptions;

public class ResourcePersistentException extends RuntimeException {

    public ResourcePersistentException(String message) {
        super(message);
    }

    public ResourcePersistentException() {
        super("Resource not persisted!");
    }

}
