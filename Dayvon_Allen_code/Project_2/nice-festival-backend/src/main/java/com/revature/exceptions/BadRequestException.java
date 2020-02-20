package com.revature.exceptions;

public class BadRequestException extends NiceException {

    public  BadRequestException() {
        super("Bad Request!");
    }

    public BadRequestException(String message) {
        super(message);
    }

}
