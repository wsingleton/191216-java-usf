package com.liberationbank.exceptions;

public class InvalidRequestException extends RuntimeException {
    public InvalidRequestException() {
        super("Invalid request made!");
    }

}
