package com.revature.revabooks.exceptions;

public class ScreenNotFoundException extends RuntimeException {

    public ScreenNotFoundException() {
        super("No screed found with the provided route!");
    }
}
