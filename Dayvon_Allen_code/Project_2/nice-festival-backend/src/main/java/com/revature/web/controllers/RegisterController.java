package com.revature.web.controllers;

import com.revature.models.*;
import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterController {
    private UserService userService;

    @Autowired
    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/customer",produces= MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
    public Customer registerNewCustomer(@RequestBody Customer newCustomer) {
        return userService.registerCustomer(newCustomer);
    }

    @PostMapping(value = "/artist",produces= MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
    public Artist registerNewCustomer(@RequestBody Artist newArtist) {
        return userService.registerArtist(newArtist);
    }

    @PostMapping(value = "/vendor",produces= MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
    public Vendor registerNewCustomer(@RequestBody Vendor newVendor) {
        return userService.registerVendor(newVendor);
    }

    @PostMapping(value = "/new-user",produces= MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
    public User registerNewUser(@RequestBody User newUser) {
        if(newUser.getRole() == null){
            newUser.setRole(Role.CUSTOMER);
        }
        return userService.registerUser(newUser);
    }
}
