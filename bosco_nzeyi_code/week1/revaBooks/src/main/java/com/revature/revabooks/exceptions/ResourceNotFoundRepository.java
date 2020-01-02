package com.revature.revabooks.exceptions;

public class ResourceNotFoundRepository extends RuntimeException {

    public ResourceNotFoundRepository() {
        super("Resource(s) not found");
    }
}
