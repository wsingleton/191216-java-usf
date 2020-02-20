package com.revature.quizzard.web.controllers;


import com.revature.quizzard.entities.AppUser;
import com.revature.quizzard.services.UserService;
import com.revature.quizzard.web.dtos.Credentials;
import com.revature.quizzard.web.dtos.Principal;
import com.revature.quizzard.web.security.JwtConfig;
import com.revature.quizzard.web.security.JwtGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private UserService userService;

    @Autowired
    public AuthController(UserService service) {
        this.userService = service;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Principal authenticate(@RequestBody Credentials creds, HttpServletResponse res) {
        Principal payload =  userService.authenticate(creds).getPrin();
        res.setHeader(JwtConfig.HEADER, JwtGenerator.createJwt(payload));
        return payload;
    }

}
