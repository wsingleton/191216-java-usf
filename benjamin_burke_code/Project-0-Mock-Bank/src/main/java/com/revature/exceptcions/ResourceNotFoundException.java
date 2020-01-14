package com.revature.exceptcions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(){
        super("No resources found");
    }
}


