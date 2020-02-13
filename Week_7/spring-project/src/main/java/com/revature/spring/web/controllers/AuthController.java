package com.revature.spring.web.controllers;

import org.springframework.http.MediaType;
import com.revature.spring.services.UserServices;
import com.revature.spring.web.dtos.Credentials;
import com.revature.spring.web.dtos.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private UserServices userServices;

    @Autowired
    public AuthController(UserServices uServices){
        super();
        this.userServices = uServices;
    }

    @PostMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
    public Principal authenticate(@RequestBody Credentials creds){
        return null;
    }
}
