package com.ers.liberation.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException() {
        super("No resource(s) found");
    }

}
