package com.revature.exceptions;

public class ScreenNotFoundException extends RuntimeException {
    public ScreenNotFoundException(){
        super("No Screen found with provided route!");
    }
}
