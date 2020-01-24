package com.revature.mockERS.services;

import com.revature.mockERS.exceptions.InvalidRequestException;
import com.revature.mockERS.exceptions.ResourceNotFoundException;
import com.revature.mockERS.exceptions.ResourcePersistenceException;
import com.revature.mockERS.models.ERS_User_Roles;
import com.revature.mockERS.models.ERS_Users;
import com.revature.mockERS.repositories.UserRepository;
import com.sun.org.apache.xpath.internal.operations.Bool;


public class UserService {
    private UserRepository userRepo;

    public UserService(UserRepository userRepo){
        this.userRepo = userRepo;
    }

    public ERS_Users login(String username, String password){
        return userRepo.findByCredentials(username, password).orElseThrow(ResourceNotFoundException::new);
    }

    public void register(ERS_Users newUser){
        if(!isUserValid(newUser)) throw new InvalidRequestException();

        if(userRepo.findByUsername(newUser.getErsUsername()).isPresent()){

            throw new ResourcePersistenceException("Username is already in use!");
        }
        newUser.setRole(ERS_User_Roles.USER);
        userRepo.addUser(newUser);
    }

    public Boolean isUserValid(ERS_Users user) {
        if (user == null) return false;
        if (user.getUser_first_name() == null || user.getUser_first_name().trim().equals("")) return false;
        if (user.getUser_last_name() == null || user.getUser_last_name().trim().equals("")) return false;
        if (user.getErsUsername() == null || user.getErsUsername().trim().equals("")) return false;
        if (user.getErsPassword() == null || user.getErsPassword().trim().equals("")) return false;
        if (user.getUser_email() == null || user.getUser_email().trim().equals("")) return false;
        return true;
    }

}
