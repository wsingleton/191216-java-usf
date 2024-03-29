package com.revature.controllers;

import com.revature.dto.Credentials;
import com.revature.dto.ErrorResponse;
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
    public AuthController(UserService service) {
        this.userService = service;
    }

    @PostMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
    public AppUser login(@RequestBody Credentials creds) {
        return userService.authenticate(creds);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorResponse handleAuthenticationException(AuthenticationException e) {
        ErrorResponse err = new ErrorResponse();
        err.setMessage(e.getMessage());
        err.setStatus(401);
        err.setTimestamp(System.currentTimeMillis());
        return err;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleBadRequestException(BadRequestException e) {
        ErrorResponse err = new ErrorResponse();
        err.setMessage(e.getMessage());
        err.setStatus(400);
        err.setTimestamp(System.currentTimeMillis());
        return err;
    }
}
