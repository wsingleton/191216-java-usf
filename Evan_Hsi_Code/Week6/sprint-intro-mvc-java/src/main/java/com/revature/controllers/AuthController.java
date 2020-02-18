package com.revature.controllers;


import com.revature.entities.Credentials;
import com.revature.entities.ErrorResponse;
import com.revature.entities.User;
import com.revature.exceptions.AuthenticationException;
import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/auth")
public class AuthController {

    private UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(consumes= MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public User authenticate(@RequestBody Credentials creds) {
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
}
