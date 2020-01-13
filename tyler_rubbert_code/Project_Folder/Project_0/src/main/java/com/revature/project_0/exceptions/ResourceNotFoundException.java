package com.revature.project_0.exceptions;

public class ResourceNotFoundException extends Exception {

    public ResourceNotFoundException() {
        super("No resource(s) found");
    }

}
