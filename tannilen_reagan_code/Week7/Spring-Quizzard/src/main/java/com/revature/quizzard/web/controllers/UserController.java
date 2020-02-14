package com.revature.quizzard.web.controllers;

import com.revature.quizzard.entities.AppUser;
import com.revature.quizzard.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public AppUser registerNewUser(@RequestBody AppUser u) {
        return userService.register(u);
    }
}
