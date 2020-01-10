package com.fauxnancials.services;

import com.fauxnancials.AppDriver;
import com.fauxnancials.exceptions.AuthenticationException;
import com.fauxnancials.exceptions.InvalidRequestException;
import com.fauxnancials.exceptions.ResourcePersistenceException;
import com.fauxnancials.models.User;
import com.fauxnancials.models.UserType;
import com.fauxnancials.repos.UserRepository;

public class UserService {
    private UserRepository userRepo;
    public UserService(UserRepository repo) {
        this.userRepo=repo;
    }
    public void authenticate(String username, int pw) {
        if (username==null || username.trim().equals("") || pw==0) {
            throw new InvalidRequestException();
        }
        AppDriver.currentUser=userRepo.findUserByCredentials(username, pw).orElseThrow(AuthenticationException::new);
    }
    public void register(User user) {
        if (!validateUserFields(user)) throw new InvalidRequestException();
        if (userRepo.findUserByUsername(user.getUsername()).isPresent()) {
            throw new ResourcePersistenceException("Username is already in use.");
        }
        user.setUserType(UserType.USER);
        userRepo.save(user);
        AppDriver.currentUser=user;
    }
    public boolean validateUserFields(User user) {
        if (user==null) return false;
        if (user.getGivenName()==null || user.getGivenName().trim().equals("")) return false;
        if (user.getFamilyName()==null || user.getFamilyName().trim().equals("")) return false;
        if (user.getUsername()==null || user.getUsername().trim().equals("")) return false;
        if (user.getPassHash()==0) return false;
        return true;
    }
}