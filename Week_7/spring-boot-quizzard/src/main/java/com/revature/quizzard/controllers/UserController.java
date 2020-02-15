package com.revature.quizzard.controllers;

import com.revature.quizzard.dtos.Credentials;
import com.revature.quizzard.entities.AppUser;
import com.revature.quizzard.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService service) {
        super();
        this.userService = service;
    }

    @GetMapping(value="/test", produces= MediaType.APPLICATION_JSON_VALUE)
    public String test() {
        return "test works!";
    }

    @GetMapping(produces= MediaType.APPLICATION_JSON_VALUE)
    public Iterable<AppUser> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(value="/id/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public AppUser getUserById(@PathVariable int id) {
        return userService.findUserById(id);
    }

    @PostMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
    public AppUser registerNewUser(@RequestBody AppUser newUser) {
        return userService.register(newUser);
    }

    @PostMapping(value="/auth", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
    public AppUser authenticate(@RequestBody Credentials creds) {
        return userService.authenticate(creds.getUsername(), creds.getPassword());
    }

}
