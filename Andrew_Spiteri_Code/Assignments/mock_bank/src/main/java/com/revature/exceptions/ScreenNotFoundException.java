package com.revature.exceptions;


public class ScreenNotFoundException extends RuntimeException {
    public ScreenNotFoundException(){
        System.out.println("Screen not found!");
    }
}
