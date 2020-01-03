package com.revature.revabooks.exceptions;

//saving or updating a user
public class ResourcePersistenceException  extends RuntimeException {

    public ResourcePersistenceException(){
        super("Resource not persisted!");
    }

    public ResourcePersistenceException(String message) {
        super(message);
    }
}
