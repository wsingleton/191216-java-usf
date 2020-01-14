package com.revature.exceptcions;

public class InvalidRequestException extends RuntimeException {

    public InvalidRequestException(){
        super("Invalid request made!");
    }
}
