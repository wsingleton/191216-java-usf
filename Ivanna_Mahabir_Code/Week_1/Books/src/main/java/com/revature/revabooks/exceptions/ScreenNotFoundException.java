package com.revature.revabooks.exceptions;

public class ScreenNotFoundException extends RuntimeException {

    public ScreenNotFoundException() {
        super("No screen found with provided route");
    }
}
