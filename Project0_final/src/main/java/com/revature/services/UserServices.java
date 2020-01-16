package com.revature.services;

import com.revature.exceptions.DuplicateException;
import com.revature.exceptions.InvalidCredentialsException;
import com.revature.models.User;
import com.revature.repos.UserRepository;

public class UserServices {

    private UserRepository uRepo;

    public UserServices(UserRepository uRepo) {
        super();
        this.uRepo = uRepo;
    }

    public void register(User newUser) {

        if (!UserValidation(newUser)) throw new InvalidCredentialsException();

        if (uRepo.findByUsername(newUser.getUsername()).isPresent()) {
            throw new DuplicateException();
        }

        uRepo.save(newUser);
    }

    public boolean UserValidation (User user) {

        if (user == null) return false;
        if (user.getUsername() == null || user.getUsername().trim().equals("")) return false;
        if (user.getPassword() == null || user.getPassword().trim().equals("")) return false;
        return true;
    }
}
