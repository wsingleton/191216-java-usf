package com.revature.revabooks.exceptions;

public class InvalidRequestExceprion extends RuntimeException {

    public InvalidRequestExceprion() {
        super("invalid request made!");
    }
}
