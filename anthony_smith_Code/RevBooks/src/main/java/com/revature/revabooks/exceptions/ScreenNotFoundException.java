package com.revature.revabooks.exceptions;

import com.revature.revabooks.screens.Screen;

public class ScreenNotFoundException extends RuntimeException{

    public ScreenNotFoundException(){
        super("No screen found with provided route!");
    }


}
