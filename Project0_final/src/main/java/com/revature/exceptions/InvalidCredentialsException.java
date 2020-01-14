package com.revature.exceptions;

public class InvalidCredentialsException extends RuntimeException {
    public InvalidCredentialsException() {
        System.out.println("The combination of username and/or password is incorrect");
    }
}
