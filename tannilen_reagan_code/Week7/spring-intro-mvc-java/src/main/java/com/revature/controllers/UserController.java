package com.revature.controllers;

import com.revature.dto.Credentials;
import com.revature.dto.ErrorResponse;
import com.revature.entities.User;
import com.revature.exceptions.AuthenticationException;
import com.revature.exceptions.BadRequestException;
import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService=userService;
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<User> getAllUsers() {
        return userService.getAll();
    }
    @GetMapping(value="/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUserById(@PathVariable int id) {
        return userService.getById(id);
    }
    @PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public User registerNewUser(@RequestBody User u) {
        return userService.register(u);
    }
    @PostMapping(value="/authenticate",consumes=MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public User authenticateUser(@RequestBody Credentials c) {
        return userService.authenticate(c);
    }
    @ExceptionHandler
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorResponse handleFailedAuthentication(AuthenticationException e){
        ErrorResponse err=new ErrorResponse();
        err.setMessage(e.getMessage());
        err.setStatus(401);
        err.setTimestamp(System.currentTimeMillis());
        return err;
    }
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleBadRequest(BadRequestException e){
        ErrorResponse err=new ErrorResponse();
        err.setMessage(e.getMessage());
        err.setStatus(400);
        err.setTimestamp(System.currentTimeMillis());
        return err;
    }
}
