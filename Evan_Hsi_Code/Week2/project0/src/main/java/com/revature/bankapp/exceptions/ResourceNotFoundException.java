package com.revature.bankapp.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {
        super("Could not find the resource." +
                "Please make sure you are entering" +
                "the correct information.");
    }
}
