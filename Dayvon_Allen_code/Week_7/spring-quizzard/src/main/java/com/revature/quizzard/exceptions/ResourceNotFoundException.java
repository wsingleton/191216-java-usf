package com.revature.quizzard.exceptions;

public class ResourceNotFoundException extends QuizzardException {
    public ResourceNotFoundException(){
        super("Bad resource");
    }
    public ResourceNotFoundException(String message){
        super(message);
    }
}
