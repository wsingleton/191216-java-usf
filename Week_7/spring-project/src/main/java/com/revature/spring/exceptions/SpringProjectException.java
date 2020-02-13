package com.revature.spring.exceptions;

public class SpringProjectException extends RuntimeException {

    public SpringProjectException(String message) {
        super(message);
    }

    public SpringProjectException(String message, Throwable cause) {
        super(message, cause);
    }

    public SpringProjectException(Throwable cause) {
        super(cause);
    }
}
