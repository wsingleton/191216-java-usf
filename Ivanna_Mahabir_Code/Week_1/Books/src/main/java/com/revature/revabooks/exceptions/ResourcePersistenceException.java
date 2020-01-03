package com.revature.revabooks.exceptions;

public class ResourcePersistenceException extends RuntimeException {

    public ResourcePersistenceException() {
        super("Resource not prersisted");
    }

    public ResourcePersistenceException(String message) {
        super(message);
    }

}
