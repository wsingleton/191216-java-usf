package com.revature.services;

import com.revature.expections.AuthenticationException;
import com.revature.expections.InvalidRequestException;
import com.revature.expections.ResourceNotFoundException;
import com.revature.expections.ResourcePersistenceException;
import com.revature.models.User;
import com.revature.repos.UserRepository;
import com.revature.models.UserRole;

import java.util.Set;

public class UserService {

    private UserRepository userRepo;

    public UserService(UserRepository repo) {
        this.userRepo = repo;
    }

    public User getUserById(int id) {
        return userRepo.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public User register(User newUser) {
        if (!isUserValid(newUser)) throw new InvalidRequestException();
        if (userRepo.findUserByUsername(newUser.getUsername()).isPresent()) {
            throw new ResourcePersistenceException("Username is already in use!");
        }
        newUser.setRole(UserRole.EMPLOYEE);
        userRepo.save(newUser);
        return newUser;
    }

    public User authenticate(String username, String password) throws InvalidRequestException {
        if (username == null || username.trim().equals("") || password == null || password.trim().equals("")) {
            throw new InvalidRequestException();
        }
        return userRepo.findUserByCredentials(username, password).orElseThrow(AuthenticationException::new);
    }

    public Set<User> getAllUsers() {
        Set<User> users;
        users = userRepo.findAll();
        if (users.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return users;
    }

    public Boolean isUserValid(User user) {
        if (user == null) return false;
        if (user.getFirstName() == null || user.getFirstName().trim().equals("")) return false;
        if (user.getLastName() == null || user.getLastName().trim().equals("")) return false;
        if (user.getUsername() == null || user.getUsername().trim().equals("")) return false;
        if (user.getPassword() == null || user.getPassword().trim().equals("")) return false;
        if (user.getEmail() == null || user.getEmail().trim().equals("")) return false;

        return true;
    }
}