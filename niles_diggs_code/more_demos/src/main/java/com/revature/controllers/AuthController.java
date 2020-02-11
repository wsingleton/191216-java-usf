package com.revature.controllers;


import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.revature.controllers.dtos.Credentials;
import com.revature.controllers.dtos.ErrorResponse;
import com.revature.entities.AppUser;
import com.revature.exceptions.AuthenticationException;
import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public AppUser loginUser(@RequestBody Credentials creds) {
        return userService.authenticate(creds);
    }

    //exception handler
    
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler
    public ErrorResponse handleFailedAuthentication(AuthenticationException e) {
        ErrorResponse err = new ErrorResponse();
        err.setMessage(e.getMessage());
        err.setStatus(401);
        err.setTimestamp(System.currentTimeMillis());
        return err;
    }
}
