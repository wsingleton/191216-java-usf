package com.revature.exceptions;

public class ResourcePersistenceException extends RuntimeException {
    public ResourcePersistenceException () {
        System.out.println("The provided credentials are unaccepted at this time");
    }
}
