package com.revature.revabooks.exceptions;

public class InvalidRequestException extends RuntimeException {

    public InvalidRequestException() {
        super("invalid request made!");
    }
}