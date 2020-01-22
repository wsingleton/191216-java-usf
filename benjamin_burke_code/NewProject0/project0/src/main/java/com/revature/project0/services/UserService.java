package com.revature.project0.services;

import com.revature.project0.exceptions.AuthenticationException;
import com.revature.project0.exceptions.InvalidRequestException;
import com.revature.project0.exceptions.ResourcePersistenceException;
import com.revature.project0.models.User;
import com.revature.project0.repos.UserRepository;

import static com.revature.project0.AppDriver.currentUser;

public class UserService {

    public UserRepository userRepo;

    public UserService(UserRepository repo) {
        this.userRepo = repo;
    }

    public UserService() {
        super();
    }

    public void register(User newUser) {

        if (!isUserValid(newUser)) throw new InvalidRequestException();

        if (userRepo.findUserByUsername(newUser.getUsername()).isPresent()) {
            throw new ResourcePersistenceException("Username is already in use!");
        }


        userRepo.save(newUser);
        currentUser = newUser;

    }

    public void authenticate(String username, String password) {

        if (username == null || username.trim().equals("")
                || password == null || password.trim().equals(""))
        {
            throw new InvalidRequestException();
        }


//        userRepo.findUserByCredentials(username, password).orElseThrow(() -> new AuthenticationException());
        currentUser = userRepo.findUserByCredentials(username, password).orElseThrow(AuthenticationException::new);
    }

    public boolean isUserValid(User user) {
        if (user == null) return false;
        if (user.getFirstName() == null || user.getFirstName().trim().equals("")) return false;
        if (user.getLastName() == null || user.getLastName().trim().equals("")) return false;
        if (user.getUsername() == null || user.getUsername().trim().equals("")) return false;
        if (user.getPassword() == null || user.getPassword().trim().equals("")) return false;
        return true;
    }
}