package com.revature.bank.exceptions;

public class ScreenNotFoundException extends RuntimeException {

    public ScreenNotFoundException(){
        super("No screen found with the provided route");
    }
}
