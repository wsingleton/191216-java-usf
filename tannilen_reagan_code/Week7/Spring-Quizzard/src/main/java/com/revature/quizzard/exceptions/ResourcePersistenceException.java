package com.revature.quizzard.exceptions;

public class ResourcePersistenceException extends QuizzardException {
    public ResourcePersistenceException() {
        super("Undefined problem occurred while attempting to save data");
    }
    public ResourcePersistenceException(String msg) {
        super(msg);
    }
}
