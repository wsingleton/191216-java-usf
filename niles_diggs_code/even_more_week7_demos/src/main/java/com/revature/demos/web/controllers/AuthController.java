package com.revature.demos.web.controllers;

import com.revature.demos.entities.AppUser;
import com.revature.demos.services.UserService;
import com.revature.demos.web.dtos.Credentials;
import com.revature.demos.web.dtos.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // the returns of every method will be in the response body
@RequestMapping("/auth")
public class AuthController {

    private UserService userService;

    @Autowired
    public AuthController(UserService service) {
        super();
        this.userService = service;

    }

    @PostMapping(value = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Principal authenticate(@RequestBody Credentials creds) {
        return userService.autheticate(creds).extractPrincipal();
    }
}
