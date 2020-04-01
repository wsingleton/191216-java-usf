package com.revature.exceptions;

public class ResourcePersistenceException extends RuntimeException {
    public ResourcePersistenceException () {
        super("This resource was not persisted correctly.");
    }
}
