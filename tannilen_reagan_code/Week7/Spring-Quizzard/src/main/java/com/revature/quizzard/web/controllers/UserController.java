package com.revature.quizzard.web.controllers;

import com.revature.quizzard.entities.AppUser;
import com.revature.quizzard.exceptions.AuthorizationException;
import com.revature.quizzard.services.UserService;
import com.revature.quizzard.web.dtos.ErrorResponse;
import com.revature.quizzard.web.security.Secured;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService service) {
        super();
        this.userService=service;
    }
    @PostMapping(produces= MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
    public AppUser registerNewUser(@Valid @RequestBody AppUser u) {
        return userService.register(u);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Secured(allowedRoles={"Admin", "Dev"})
    public List<AppUser> getAllUsers(HttpServletRequest req) {
        return userService.getAllUsers();
    }
    @ExceptionHandler
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorResponse handleAuthorizationException(AuthorizationException e) {
        ErrorResponse err=new ErrorResponse();
        err.setMessage(e.getMessage());
        err.setTimestamp(System.currentTimeMillis());
        err.setStatus(403);
        return err;
    }
    @ExceptionHandler
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorResponse handleAuthenticationException(AuthorizationException e) {
        ErrorResponse err=new ErrorResponse();
        err.setMessage(e.getMessage());
        err.setTimestamp(System.currentTimeMillis());
        err.setStatus(401);
        return err;
    }
}
