package com.revature.exceptions;

public class ResourceNotFoundException extends NiceException {

    public  ResourceNotFoundException() {
        super("This resource was not found!");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
