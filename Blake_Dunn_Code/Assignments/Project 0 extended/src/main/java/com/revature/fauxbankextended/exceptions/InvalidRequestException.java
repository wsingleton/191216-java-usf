package com.revature.fauxbankextended.exceptions;

public class InvalidRequestException extends RuntimeException {

    public InvalidRequestException() {
        super("Invalid request made!");
    }
}
