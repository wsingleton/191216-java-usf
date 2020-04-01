package com.revature.exceptions;

public class InvalidInputException extends RuntimeException {
    public InvalidInputException() {
        super("This entry is not valid");
    }
}
