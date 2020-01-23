package com.revature.mockERS.services;

import com.revature.mockERS.exceptions.ResourceNotFoundException;
import com.revature.mockERS.models.ERS_Users;
import com.revature.mockERS.repositories.UserRepository;
import com.sun.org.apache.xpath.internal.operations.Bool;


public class UserService {
    private UserRepository userRepo;

    public UserService(UserRepository userRepo){
        this.userRepo = userRepo;
    }

    public ERS_Users login(String username, String password){
        return userRepo.findByCredentials(username, password).orElseThrow(ResourceNotFoundException::new);
    }
}
