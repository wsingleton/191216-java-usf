package com.revature.ers.services;

import com.revature.ers.exceptions.AuthenticationException;
import com.revature.ers.exceptions.InvalidRequestException;
import com.revature.ers.exceptions.ResourceNotFoundException;
import com.revature.ers.exceptions.ResourcePersistenceException;
import com.revature.ers.models.Role;
import com.revature.ers.models.User;
import com.revature.ers.repos.UserRepository;

import java.util.Set;

public class UserService {

    private UserRepository userRepo;

    public UserService(UserRepository repo) {
        this.userRepo = repo;
    }

    public User getUserById(int id) throws ResourceNotFoundException {
        return userRepo.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public User register(User newUser) throws InvalidRequestException, ResourcePersistenceException {
        if (!isUserValid(newUser)) throw new InvalidRequestException();
        if (userRepo.findUserByUsername(newUser.getUsername()).isPresent()) {
            throw new ResourcePersistenceException();
        }
        newUser.setRole(Role.EMPLOYEE);
        userRepo.save(newUser);
        return newUser;
    }

    public User authenticate(String username, String password) throws InvalidRequestException {
        if (username == null || username.trim().equals("") || password == null || password.trim().equals("")) {
            throw new InvalidRequestException();
        }
        return userRepo.findUserByCredentials(username, password).orElseThrow(AuthenticationException::new);
    }

    public Set<User> getAllUsers() throws ResourceNotFoundException {
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
