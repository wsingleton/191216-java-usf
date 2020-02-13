package com.revature.spring.exceptions;

public class RessourcePersistenceException extends SpringProjectException {
    public RessourcePersistenceException() {
        super("Resources persistence error");
    }
}
