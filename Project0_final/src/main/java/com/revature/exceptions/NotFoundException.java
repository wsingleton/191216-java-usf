package com.revature.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        System.out.println("Unable to find the requested information");
    }
}
