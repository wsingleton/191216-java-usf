package com.revature.controllers;

import com.revature.entities.AppUser;
import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
    public Set<AppUser> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping(value="/id/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
    public AppUser getUserById(@PathVariable int id) {
        return userService.getById(id);
    }

    @PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public AppUser registerNewUser(@RequestBody AppUser newUser) {
        return userService.register(newUser);
    }

}
