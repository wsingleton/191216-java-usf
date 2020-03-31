package com.revature.controllers;

import com.revature.dtos.Credentials;
import com.revature.dtos.ErrorResponse;
import com.revature.entities.AppUser;
import com.revature.exceptions.AuthenticationException;
import com.revature.exceptions.BadRequestException;
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
    public AuthController(UserService userService){
        this.userService = userService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AppUser loginUser(@RequestBody Credentials creds){
        return userService.authenticate(creds);
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler
    public ErrorResponse handleAuthenticationException(AuthenticationException e){
        ErrorResponse err = new ErrorResponse();
        err.setMessage(e.getMessage());
        err.setStatus(401);
        err.setTimestamp(System.currentTimeMillis());
        return err;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    public ErrorResponse handleBadRequestException(BadRequestException e){
        ErrorResponse err = new ErrorResponse();
        err.setMessage(e.getMessage());
        err.setStatus(400);
        err.setTimestamp(System.currentTimeMillis());
        return err;
    }
}
