package com.revature.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(){
        super("No resourc(s) found");
    }
}
