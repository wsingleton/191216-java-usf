package com.revature.fauxbank.exceptions;

import static com.revature.fauxbank.BankDriver.router;

public class InvalidAmountException extends RuntimeException {

    public InvalidAmountException() {
        super("That is not valid amount.");
        router.navigate("/dashboard");
    }
}
