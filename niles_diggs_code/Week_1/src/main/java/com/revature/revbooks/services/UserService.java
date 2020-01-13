package com.revature.revbooks.services;

import com.revature.revbooks.exceptions.AuthenticationException;
import com.revature.revbooks.exceptions.InvalidRequestException;
import com.revature.revbooks.exceptions.ResourcePersistenceException;
import com.revature.revbooks.models.Role;
import com.revature.revbooks.models.User;
import com.revature.revbooks.repos.UserRepository;

import static com.revature.revbooks.AppDriver.currentUser;

public class UserService {

    private UserRepository userRepo;

    public UserService(UserRepository repo) {
        this.userRepo = repo;
    }

    public void register(User newUser) {
        if (!isUserValid(newUser)) throw new InvalidRequestException();

        if(userRepo.findUserByUsername(newUser.getUsername()).isPresent()) {
            throw new ResourcePersistenceException("Username is already in use!");
        }

        newUser.setRole(Role.BASIC_MEMBER);
        userRepo.save(newUser);
        currentUser = newUser;

    }

    public void authenticate(String username, String password) {

        if (username == null || username.trim().equals("")
                || password == null || password.trim().equals("")) {
            throw new InvalidRequestException();
        }

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
