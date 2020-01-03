package com.revature.revabooks.services;

import com.revature.revabooks.AppDriver;
import com.revature.revabooks.exceptions.AuthenticationException;
import com.revature.revabooks.exceptions.InvalidRequestException;
import com.revature.revabooks.exceptions.ResourcePersistenceException;
import com.revature.revabooks.models.Role;
import com.revature.revabooks.models.User;
import com.revature.revabooks.repos.UserRepository;

import java.util.Set;

public class UserService {
    private UserRepository userRepo;
    public UserService(UserRepository repo) {
        this.userRepo=repo;
    }
    public Set<User> getAllUser() {
        return null;
    }
    public Set<User> getUsersByRole(Role role) {
        return null;
    }
    public User getUserByID(int id) {
        return null;
    }
    public User getUserByUsername(String username) {
        return null;
    }
    public void authenticate(String username, String pw) {
        if (username==null || username.trim().equals("") || pw==null || pw.trim().equals("")) {
            throw new InvalidRequestException();
        }
        AppDriver.currentUser=userRepo.findUserByCredentials(username, pw).orElseThrow(AuthenticationException::new);
    }
    public void register(User user) {
        if (!validateUserFields(user)) throw new InvalidRequestException();
        if (userRepo.findUserByUsername(user.getUsername()).isPresent()) {
            throw new ResourcePersistenceException("Username is already in use.");
        }
        user.setRole(Role.BASIC_MEMBER);
        userRepo.save(user);
        AppDriver.currentUser=user;
    }
    public boolean updateUser(User user) {
        return false;
    }
    public boolean deleteUserByID(int id) {
        return false;
    }
    public boolean validateUserFields(User user) {
        if (user==null) return false;
        if (user.getFirstName()==null || user.getFirstName().trim().equals("")) return false;
        if (user.getLastName()==null || user.getLastName().trim().equals("")) return false;
        if (user.getUsername()==null || user.getUsername().trim().equals("")) return false;
        if (user.getPassword()==null || user.getPassword().trim().equals("")) return false;
        return true;
    }
}
