package com.revature.ers.services;

import com.revature.ers.exceptions.AuthenticationException;
import com.revature.ers.exceptions.InvalidRequestException;
import com.revature.ers.exceptions.ResourceNotFoundException;
import com.revature.ers.exceptions.ResourcePersistenceException;
import com.revature.ers.models.Role;
import com.revature.ers.models.User;
import com.revature.ers.repos.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;

public class UserService {

    private UserRepository userRepo;
    private static final Logger LOG = LogManager.getLogger(UserService.class);

    public UserService(UserRepository repo) {
        super();
        this.userRepo = repo;
    }

    public User register(User newUser) {
        LOG.info("Validating new user credentials");
        if (!isUserValid(newUser)) throw new InvalidRequestException();

        if (userRepo.findUserByUsername(newUser.getUsername()).isPresent()) {
            throw new ResourcePersistenceException("Username is already in use!");
        }

        LOG.info("Setting the role for newly registered user");
        newUser.setRole(Role.EMPLOYEE);

        LOG.info("Saving new user credentials");
        User currentUser = userRepo.save(newUser);

        return currentUser;

    }

    public User getUserById(int id) {
        return userRepo.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public Set<User> getAllUsers() {

        Set<User> users;

        users = userRepo.findAll();

        if (users.isEmpty()) {
            LOG.warn("Request could not be made.");
            throw new ResourceNotFoundException();
        }

        return users;

    }

    public User authenticate(String username, String password) {
        LOG.info("Authenticating user credentials");
        if (username == null || username.trim().equals("") || password == null || password.trim().equals("")) {
            throw new InvalidRequestException();
        }

        LOG.info("Credentials were validated");
        return userRepo.getUser(username, password);

    }

    public Boolean updateProfile(User updatedUser) {

        Boolean profileUpdated;

        if (!isUserValid(updatedUser)) {
            LOG.warn("Request could not be made.");
            throw new InvalidRequestException();
        }

        Optional<User> persistedUser = userRepo.findUserByUsername(updatedUser.getUsername());
        if (persistedUser.isPresent() && !persistedUser.get().getUserId().equals(updatedUser.getUserId())) {
            LOG.warn("Username update failed");
            throw new ResourcePersistenceException("That username is taken by someone else!");
        }

        profileUpdated = userRepo.update(updatedUser);

        return profileUpdated;

    }

    public Boolean isUserValid(User user) {
        if (user == null) return false;
        if (user.getFirstName() == null || user.getFirstName().trim().equals("")
                || !(user.getFirstName().matches("^[a-zA-Z]*$"))) return false;
        if (user.getLastName() == null || user.getLastName().trim().equals("")
                || !(user.getLastName().matches("^[a-zA-Z]*$"))) return false;
        if (user.getUsername() == null || user.getUsername().trim().equals("")) return false;
        if (user.getPassword() == null || user.getPassword().trim().equals("")) return false;
        if (user.getEmail() == null || user.getEmail().trim().equals("")
                || !(user.getEmail().matches("^(.+)@(.+)$"))) return false;
        return true;
    }
}
