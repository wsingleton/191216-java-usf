package com.revature.project_0.services;

import com.revature.project_0.repos.UserRepository;

public class UserService {

    private UserRepository userRepo;

    public UserService(UserRepository repo) {
        super();
        this.userRepo = repo;
    }


}
