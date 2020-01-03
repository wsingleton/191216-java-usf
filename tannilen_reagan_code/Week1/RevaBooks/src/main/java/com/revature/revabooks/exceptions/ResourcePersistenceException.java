package com.revature.revabooks.exceptions;

public class ResourcePersistenceException extends RuntimeException {
    public ResourcePersistenceException() {
        super("Save or update function has failed.");
    }
    public ResourcePersistenceException(String msg) {
        super(msg);
    }
}
