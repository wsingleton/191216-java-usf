package com.revature.services;

import com.revature.exceptions.AuthenticationException;
import com.revature.exceptions.InvalidRequestException;
import com.revature.exceptions.ResourcePersistentException;
import com.revature.models.User;
import com.revature.repos.UserRepository;
import static com.revature.BankDriver.currentUser;


public class UserService {

    private UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public void register(User newUser) throws InvalidRequestException, ResourcePersistentException {
        if(!isUserValidate(newUser)){
            throw new InvalidRequestException();
        }
        if(userRepo.findUserByUsername(newUser.getUsername()).isPresent()){
            throw new ResourcePersistentException();
        }
        userRepo.save(newUser);
        currentUser = newUser;
    }

    public void authenticate(String username, String password) throws InvalidRequestException, AuthenticationException {
        if(username == null || username.trim().equals("") || password == null || password.trim().equals("")){
            throw new InvalidRequestException();
        }
        currentUser = userRepo.findUserByCredentials(username, password).orElseThrow(AuthenticationException::new);
    }

    public boolean isUserValidate(User user){
        if(user == null) {
            return false;
        }
        if(user.getUsername() == null || user.getUsername().trim().equals("")){
            return false;
        }
        if(user.getPassword() == null || user.getPassword().trim().equals("")){
            return false;
        }
        return true;
    }
}
