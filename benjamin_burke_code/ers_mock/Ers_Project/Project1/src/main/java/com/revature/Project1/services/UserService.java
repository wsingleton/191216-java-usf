package com.revature.Project1.services;

import com.revature.Project1.exceptions.ResourcePersistenceException;
import com.revature.Project1.models.Role;
import com.revature.Project1.models.User;
import com.revature.Project1.repos.UserRepository;
import com.revature.Project1.exceptions.ResourceNotFoundException;
import com.revature.reimbursement_app.exceptions.AuthenticationException;
import com.revature.reimbursement_app.exceptions.InvalidRequestException;
import com.revature.reimbursement_app.exceptions.ResourceNotFoundException;
import com.revature.reimbursement_app.exceptions.ResourcePersistenceException;
import com.revature.reimbursement_app.models.Role;
import com.revature.reimbursement_app.models.User;
import com.revature.reimbursement_app.repos.UserRepository;

import java.util.Optional;
import java.util.Set;

public class UserService {

    private UserRepository userRepo;

    public UserService(UserRepository repo) {
        super();
        this.userRepo = repo;
    }

    public User getUserById(int id) {
        return userRepo.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public void register(User newUser) {

        if (!isUserValid(newUser)) throw new InvalidRequestException();

        if (userRepo.findUserByUsername(newUser.getUsername()).isPresent()) {
            throw new ResourcePersistenceException("Username already in use!");
        }

        newUser.setRole(Role.BASIC_USER);
        userRepo.save(newUser);

    }

    public Set<User> getAllUsers() {

        Set<User> users;

        users = userRepo.findAll();

        if (users.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        return users;

    }

    public Set<User> getUsersByRole(Role role) {

        Set<User> users;

        if (role == null) {
            throw new InvalidRequestException();
        }

        users = userRepo.findUsersByRole(role);

        if (users.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        return users;

    }

    public User getUserByUsername(String username) {

        if (username == null || username.trim().equals("")) {
            throw new InvalidRequestException();
        }

        return userRepo.findUserByUsername(username).orElseThrow(ResourceNotFoundException::new);

    }

    public User authenticate(String username, String password) {

        if (username == null || username.trim().equals("") || password == null || password.trim().equals("")) {
            throw new InvalidRequestException();
        }

        return userRepo.findUserByCredentials(username, password).orElseThrow(AuthenticationException::new);

    }

    public Boolean updateProfile(User updatedUser) {

        Boolean profileUpdated;

        if (!isUserValid(updatedUser)){
            throw new InvalidRequestException();
        }

        Optional<User> persistedUser = userRepo.findUserByUsername(updatedUser.getUsername());
        if (persistedUser.isPresent() && persistedUser.get().getId() != updatedUser.getId()) {
            throw new ResourcePersistenceException("That username is taken by someone else!");
        }

        profileUpdated = userRepo.update(updatedUser);

        return profileUpdated;

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
