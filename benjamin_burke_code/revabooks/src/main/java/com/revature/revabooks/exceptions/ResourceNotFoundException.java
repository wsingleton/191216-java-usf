package com.revature.revabooks.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(){
        super("No resources found");
    }

}
