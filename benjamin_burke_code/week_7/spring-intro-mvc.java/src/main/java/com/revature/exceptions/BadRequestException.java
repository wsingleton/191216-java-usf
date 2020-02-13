package com.revature.exceptions;

import org.springframework.web.client.HttpClientErrorException;

public class BadRequestException extends RuntimeException {

    public BadRequestException(){
        super("Bad Request Exception");
    }
}
