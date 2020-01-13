package com.revature.project_0.exceptions;

public class ResourcePersistentException extends Exception {

    public ResourcePersistentException() {
        super("Resource not persisted!");
    }

    public ResourcePersistentException(String message) {
        super(message);
    }

}
