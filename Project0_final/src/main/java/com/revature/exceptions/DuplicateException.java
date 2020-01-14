package com.revature.exceptions;

public class DuplicateException extends RuntimeException {
    public DuplicateException() {
        System.out.println("The requested username is unavailable at this time");
    }
}
