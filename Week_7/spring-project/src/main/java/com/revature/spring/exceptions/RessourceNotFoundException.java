package com.revature.spring.exceptions;

public class RessourceNotFoundException extends SpringProjectException{


    public RessourceNotFoundException() {
        super("ressources not found");
    }
}
