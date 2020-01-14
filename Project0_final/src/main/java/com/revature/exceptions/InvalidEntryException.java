package com.revature.exceptions;

public class InvalidEntryException extends RuntimeException {
    public InvalidEntryException() {
        System.out.println("This entry is not permitted");
    }
}
