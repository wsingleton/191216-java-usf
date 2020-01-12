package com.revature.revabank.exceptions;

public class InvalidRequestException extends RuntimeException {
    public InvalidRequestException(){
        super("Invalid Request Made!");
    }
}
