package com.revature.spring.exceptions;

public class BadRequestException extends SpringProjectException {
    public BadRequestException() {
        super("Invalid request");
    }
}
