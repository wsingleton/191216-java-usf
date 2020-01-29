package com.revature.exceptions;

public class AuthenticationException extends RuntimeException {
    public AuthenticationException() {
        System.out.println("The provided credentials are invalid");
    }

}
