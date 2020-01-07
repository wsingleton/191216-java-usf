package com.liberationbank.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(){
        super("No resource(s) found");
    }

}
