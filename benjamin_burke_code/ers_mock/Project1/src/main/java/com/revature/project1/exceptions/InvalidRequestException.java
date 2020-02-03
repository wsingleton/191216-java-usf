package com.revature.project1.exceptions;

public class InvalidRequestException extends RuntimeException {
    public InvalidRequestException(){
        super("Invalid Request made!");
    }

    public InvalidRequestException(String message){
        super(message);
    }
}
