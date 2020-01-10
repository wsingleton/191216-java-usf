package com.revature.project0.exceptions;

public class InvalidRequestException extends RuntimeException {

    public InvalidRequestException() {
        super("invalid request made!");
    }
}
