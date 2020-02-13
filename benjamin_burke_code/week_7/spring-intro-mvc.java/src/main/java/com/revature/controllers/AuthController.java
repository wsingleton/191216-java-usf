package com.revature.controllers;

import com.revature.dtos.Credentials;
import com.revature.dtos.ErrorResponse;
import com.revature.entities.AppUser;
import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private UserService userService;

    @Autowired
    public AuthController(UserService service){
        this.userService= service;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE){
        public AppUser login(Credentials creds){
        return userService.authenticate(creds)
        }

        public ErrorResponse handle
    }
}
