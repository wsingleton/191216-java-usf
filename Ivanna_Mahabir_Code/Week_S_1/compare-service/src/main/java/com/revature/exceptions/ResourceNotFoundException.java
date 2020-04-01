package com.revature.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException() {
        super("The specified resource is not available at this time");
    }
}
