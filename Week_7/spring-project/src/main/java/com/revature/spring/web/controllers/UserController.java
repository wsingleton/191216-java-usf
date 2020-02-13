package com.revature.spring.web.controllers;


import com.revature.spring.entities.AppUser;
import com.revature.spring.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
