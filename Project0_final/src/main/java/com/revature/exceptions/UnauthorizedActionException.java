package com.revature.exceptions;

public class UnauthorizedActionException extends RuntimeException {
    public UnauthorizedActionException() {
        System.out.println("You don't have permission to perform this action");
    }
}
