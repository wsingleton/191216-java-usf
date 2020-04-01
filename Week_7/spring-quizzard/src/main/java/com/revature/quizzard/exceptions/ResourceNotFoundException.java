package com.revature.quizzard.exceptions;

public class ResourceNotFoundException extends QuizzardException {

    public ResourceNotFoundException() {
        super("No resource found with provided search criteria!");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }

}
