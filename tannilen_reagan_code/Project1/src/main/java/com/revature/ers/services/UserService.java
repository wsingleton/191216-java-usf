package com.revature.ers.services;

import com.revature.ers.exceptions.AuthenticationException;
import com.revature.ers.exceptions.InvalidRequestException;
import com.revature.ers.models.User;
import com.revature.ers.repos.UserRepository;

public class UserService {
    private UserRepository userRepo;
    public UserService(UserRepository repo) {
        this.userRepo=repo;
    }
    public User authenticate(String username, String pw) {
        if (username==null || username.trim().equals("") || pw==null || pw.trim().equals("")) {
            throw new InvalidRequestException();
        }
       return userRepo.findUserByCredentials(username, pw).orElseThrow(AuthenticationException::new);
    }
    //maybe add a process to update your password?
}