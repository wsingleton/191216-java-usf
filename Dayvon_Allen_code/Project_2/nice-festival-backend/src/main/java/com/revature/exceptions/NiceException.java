package com.revature.exceptions;

public class NiceException extends RuntimeException{

    public NiceException(String message) {
        super(message);
    }

    public NiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public NiceException(Throwable cause) {
        super(cause);
    }
}
