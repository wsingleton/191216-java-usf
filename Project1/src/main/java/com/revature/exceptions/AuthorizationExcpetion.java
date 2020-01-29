package com.revature.exceptions;

public class AuthorizationExcpetion extends RuntimeException {
   public AuthorizationExcpetion () {
       System.out.println("You do not have the required privileges to perform this action");
   }
}
