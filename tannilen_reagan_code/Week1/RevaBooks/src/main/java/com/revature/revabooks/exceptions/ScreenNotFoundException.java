package com.revature.revabooks.exceptions;

public class ScreenNotFoundException extends RuntimeException {
    public ScreenNotFoundException() {
        super("404\nnot found");
    }
}
