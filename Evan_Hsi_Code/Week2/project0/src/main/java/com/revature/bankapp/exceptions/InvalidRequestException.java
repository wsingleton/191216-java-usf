package com.revature.bankapp.exceptions;


public class InvalidRequestException extends RuntimeException {

    public InvalidRequestException() {
        super("Invalid request made!");
    }
}
