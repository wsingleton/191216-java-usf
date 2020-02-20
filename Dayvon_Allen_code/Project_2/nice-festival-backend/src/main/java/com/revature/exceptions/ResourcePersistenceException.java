package com.revature.exceptions;

public class ResourcePersistenceException extends NiceException {

    public  ResourcePersistenceException() {
        super("Error saving resource!");
    }

    public ResourcePersistenceException(String message) {
        super(message);
    }
}
