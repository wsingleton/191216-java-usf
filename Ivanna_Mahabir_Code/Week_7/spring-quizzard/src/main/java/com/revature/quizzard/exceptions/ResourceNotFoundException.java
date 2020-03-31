package com.revature.quizzard.exceptions;

public class ResourceNotFoundException extends QuizzardException {

    public ResourceNotFoundException() {
        super("No resouce");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
