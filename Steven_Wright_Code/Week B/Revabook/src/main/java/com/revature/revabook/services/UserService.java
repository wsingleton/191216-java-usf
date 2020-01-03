package com.revature.revabook.services;

import com.revature.revabook.exceptions.InvalidRequestException;
import com.revature.revabook.models.User;
import repos.UserRepository;

public class UserService {

    private UserRepository userRepo;

    public UserServices(UserRepository repo)

    public void register(User newUser) {
       if(!isUserVaild(newUser))  throw new InvalidRequestException();
    }

    public boolean isUserVaild(User user) {
        if (user == null) return false;
        if(user.getFirstName() == null || user.getFirstName().trim().equals("")) return false;
    }
}


