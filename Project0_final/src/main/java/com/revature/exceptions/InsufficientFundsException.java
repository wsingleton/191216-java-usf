package com.revature.exceptions;

public class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException() {
        System.out.println("You must deposit more money before you can perform this action");
    }
}
