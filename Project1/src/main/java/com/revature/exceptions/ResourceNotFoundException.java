package com.revature.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException () {
        System.out.println("The requested information does not exist");
    }
}
