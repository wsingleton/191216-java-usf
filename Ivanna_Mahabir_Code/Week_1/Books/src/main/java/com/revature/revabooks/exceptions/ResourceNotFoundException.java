package com.revature.revabooks.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {
        super("No resoure(s) found");

    }

}
