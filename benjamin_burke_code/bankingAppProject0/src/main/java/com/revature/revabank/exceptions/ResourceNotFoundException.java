package com.revature.revabank.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(){
        super("No resources found");
    }
}
