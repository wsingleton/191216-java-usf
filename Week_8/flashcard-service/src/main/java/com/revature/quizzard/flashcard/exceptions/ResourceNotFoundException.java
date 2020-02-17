package com.revature.quizzard.flashcard.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {
        super("No resource found!");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
