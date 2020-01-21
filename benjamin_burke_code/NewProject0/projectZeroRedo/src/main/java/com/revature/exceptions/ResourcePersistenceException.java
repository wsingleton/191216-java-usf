package com.revature.exceptions;

public class ResourcePersistenceException extends RuntimeException{

    public ResourcePersistenceException(String s){super("Resources not persisted");}
}
