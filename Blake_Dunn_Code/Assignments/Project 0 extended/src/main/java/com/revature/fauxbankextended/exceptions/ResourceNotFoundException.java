package com.revature.fauxbankextended.exceptions;

import static com.revature.fauxbankextended.BankDriver.app;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {
        super("No resource(s) found");
        app().invalidateCurrentSession();
        app().getRouter().navigate("/home");
    }
}
