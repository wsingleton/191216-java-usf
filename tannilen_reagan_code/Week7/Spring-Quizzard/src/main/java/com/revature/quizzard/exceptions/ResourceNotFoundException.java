package com.revature.quizzard.exceptions;

public class ResourceNotFoundException extends QuizzardException {
    public ResourceNotFoundException() {
        super("No such resource found");
    }
    public ResourceNotFoundException(String msg) {
        super(msg);
    }
}
