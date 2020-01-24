package com.revature.mockERS.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException() {
        super("No resource(s) found");
    }

}
