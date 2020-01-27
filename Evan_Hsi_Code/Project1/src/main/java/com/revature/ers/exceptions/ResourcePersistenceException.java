package com.revature.ers.exceptions;

public class ResourcePersistenceException extends RuntimeException {

    public ResourcePersistenceException() { super("Resource Not Persisted"); }

    public ResourcePersistenceException(String message) { super(message); }

}
