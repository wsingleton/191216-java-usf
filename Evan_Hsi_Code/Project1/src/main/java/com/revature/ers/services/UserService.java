package com.revature.ers.services;

import com.revature.ers.exceptions.AuthenticationException;
import com.revature.ers.exceptions.InvalidRequestException;
import com.revature.ers.exceptions.ResourceNotFoundException;
import com.revature.ers.exceptions.ResourcePersistenceException;
import com.revature.ers.models.Role;
import com.revature.ers.models.User;
import com.revature.ers.repositories.UserRepository;

import java.util.Optional;
import java.util.Set;

// change email in isUserValid to regex;

public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void register(User newUser) {
        System.out.println(newUser);

        if( !isUserValid(newUser)) throw new InvalidRequestException();
        System.out.println("valid");

        if (userRepository.findUserByUsername(newUser.getUsername()).isPresent()) {
            System.out.println("username");
            throw new ResourcePersistenceException("Username is already in use!");
        }
        System.out.println("wtf");
        newUser.setRole(Role.LOCKED);
        userRepository.save(newUser);
    }

    public Set<User> getAllUsers() {

        Set<User> users;

        users = userRepository.findAll();

        if(users.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        return users;
    }

    public void confirmAccount(int id) {
        userRepository.confirmAccount(id);
    }

    public User getUserByUsername(String username) {

        if (username == null || username.trim().equals("")) {
            throw new InvalidRequestException();
        }

        return userRepository.findUserByUsername(username).orElseThrow(ResourceNotFoundException::new);

    }

    public User getUserById(int id) {
        return userRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public User authenticate(String username, String password) {

        if (username == null || username.trim().equals("") || password == null || password.trim().equals("")) {
            throw new InvalidRequestException();
        }

        return userRepository.findUserByCredentials(username, password).orElseThrow(AuthenticationException::new);

    }

    public Boolean updateProfile(User updatedUser) {

        Boolean profileUpdated;

        if (!isUserValid(updatedUser)) {
            throw new InvalidRequestException();
        }

        Optional<User> persistedUser = userRepository.findUserByUsername(updatedUser.getUsername());
        if (persistedUser.isPresent() && persistedUser.get().getId() != updatedUser.getId()) {
            throw new ResourcePersistenceException("That username is taken by someone else!");
        }

        profileUpdated = userRepository.update(updatedUser);

        return profileUpdated;
    }

    public Boolean isUserValid(User user) {
        if (user == null) return false;
        if (user.getFirstname() == null || user.getFirstname().trim().equals("")) return false;
        if (user.getLastname() == null || user.getLastname().trim().equals("")) return false;
        if (user.getUsername() == null || user.getUsername().trim().equals("")) return false;
        if (user.getPassword() == null || user.getPassword().trim().equals("")) return false;

        //change to regex

        if (user.getEmail() == null || user.getEmail().trim().equals("")) return false;
        return true;
    }
}
