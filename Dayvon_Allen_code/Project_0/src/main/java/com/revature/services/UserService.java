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
        //checks if user is valid
        if(!isUserValidate(newUser)){
            throw new InvalidRequestException();
        }
        //checks if the username exists
        if(userRepo.findUserByUsername(newUser.getUsername()).isPresent()){
            throw new ResourcePersistentException();
        }
        //saves the user
        userRepo.save(newUser);
        //changes the new user to the current user of the app
        currentUser = newUser;
    }

    public void authenticate(String username, String password) throws InvalidRequestException, AuthenticationException {
        //checks if the user's input is valid
        if(username == null || username.trim().equals("") || password == null || password.trim().equals("")){
            throw new InvalidRequestException();
        }
        //checks if credentials are correct, if not throws authentication exception
        currentUser = userRepo.findUserByCredentials(username, password).orElseThrow(AuthenticationException::new);
    }

    //checks if the user data is valid
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
        if(user.getPassword() == null || user.getPassword().trim().contains(";")){
            return false;
        }
        if(user.getUsername().matches("[^A-Za-z0-9]+")){
            return false;
        }
        return true;
    }
}
