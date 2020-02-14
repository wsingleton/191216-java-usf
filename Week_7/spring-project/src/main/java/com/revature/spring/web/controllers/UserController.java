package com.revature.spring.web.controllers;


import com.revature.spring.entities.AppUser;
import com.revature.spring.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserServices userServices;

    @Autowired
    public UserController(UserServices services){
        super();
        this.userServices = services;
    }

    @PostMapping(produces= MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
    public AppUser registerNewUser(@RequestBody AppUser user){
        return userServices.register(user);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<AppUser> getUsers(){return userServices.getAllUsers();}
}
