package com.fauxnancials.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException() {
        super("No data found matching provided parameters.");
    }
}
