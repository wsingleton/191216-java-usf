package com.revature.bankapp.exceptions;

public class ResourcePersistenceException extends RuntimeException {

    public ResourcePersistenceException() {
        super("Resource not persisted");
    }
}
