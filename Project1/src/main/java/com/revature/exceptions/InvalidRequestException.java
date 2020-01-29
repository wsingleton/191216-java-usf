package com.revature.exceptions;

public class InvalidRequestException extends RuntimeException {
    public InvalidRequestException () {
        System.out.println("The requested action does not exist");
    }
}
