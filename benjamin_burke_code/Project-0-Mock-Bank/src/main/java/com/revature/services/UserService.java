package com.revature.services;

import com.revature.exceptcions.AuthenticationException;
import com.revature.exceptcions.InvalidRequestException;
import com.revature.exceptcions.ResourcePersistenceException;
import com.revature.models.User;
import com.revature.repos.UserRepository;

import static com.revature.AppDriver.currentUser;

public class UserService {
    private UserRepository userRepo;



    public UserService(UserRepository repo){
        this.userRepo=repo;

    }

    public void register(User newUser) {

        if (!isUserValid(newUser)) throw new InvalidRequestException();

        if (userRepo.findUserByUsername(newUser.getUsername()).isPresent()) {
            throw new ResourcePersistenceException("Username is already in use!");
        }


        userRepo.save(newUser);
        currentUser = newUser;

    }


    public void authenticate(String username, String password){
        if (username== null || username.trim().equals("")
                || password == null || password.trim().equals(""))
        {
            throw new InvalidRequestException();
        }
//        userRepo.findUserByCredentials(username, password).orElseThrow(()->new AuthenticationException());
//        userRepo.findUserByCredentials(username, password).orElseThrow(AuthenticationException::new);
        currentUser = userRepo.findUserByCredentials(username, password).orElseThrow(AuthenticationException::new);
    }

    public boolean isUserValid(User user) {
        if(user == null) return false;

        if(user.getUsername()==null || user.getUsername().trim().equals("")) return false;
        if(user.getPassword()==null || user.getPassword().trim().equals("")) return false;

        return true;
    }
}
