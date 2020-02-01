package com.revature.ers.services;

import com.revature.ers.exceptions.AuthenticationException;
import com.revature.ers.exceptions.InvalidRequestException;
import com.revature.ers.exceptions.UnauthorizedRequestException;
import com.revature.ers.models.User;
import com.revature.ers.repos.UserRepository;

import java.util.HashSet;
import java.util.Set;

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
    public Set<User> findAllUsers(int role){
        Set<User> users=new HashSet<>();
        if (role!=1) {
            throw new UnauthorizedRequestException();
        }
        users=userRepo.findAll();
        return users;
    }
    //maybe add a process to update your password?
}
