package com.revature.project_0.exceptions;

public class ScreenNotFoundException extends Exception {

    public ScreenNotFoundException() {
        super("No screen found with provided route!");
    }

}
