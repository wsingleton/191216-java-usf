package com.revature.demos.exceptions;

public class ResourceNotFoundException extends QuizzardException {
    public ResourceNotFoundException() {
        super("The requested information does not exist");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
