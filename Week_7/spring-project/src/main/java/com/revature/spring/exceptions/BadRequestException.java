package com.revature.spring.exceptions;

public class BadRequestException extends SpringProjectException {
    public BadRequestException(String s) {
        super("Invalid request");
    }
}
