package com.revature.fauxbankextended.exceptions;

public class InvalidAmountException extends RuntimeException {

    public InvalidAmountException() {
        super("That is not valid amount.");
//        router.navigate("/dashboard");
    }
}
