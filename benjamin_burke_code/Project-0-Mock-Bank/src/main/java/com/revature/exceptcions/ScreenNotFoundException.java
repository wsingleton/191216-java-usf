package com.revature.exceptcions;

public class ScreenNotFoundException extends RuntimeException {

    public ScreenNotFoundException(){
        super("No Screen found with provided route!");
    }

}
