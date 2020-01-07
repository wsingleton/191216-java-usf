package com.liberationbank.exceptions;

public class AuthorizationException extends RuntimeException {

    public AuthorizationException(){super("You do not have proper permissions to perform that action!");}

}
