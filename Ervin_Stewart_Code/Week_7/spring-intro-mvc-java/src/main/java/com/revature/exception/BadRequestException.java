package com.revature.exception;

public class BadRequestException extends RuntimeException {

    public BadRequestException() {
        super("Invalid request made!");
    }
}