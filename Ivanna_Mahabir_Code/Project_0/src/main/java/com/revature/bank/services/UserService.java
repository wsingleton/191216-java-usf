package com.revature.bank.services;

import com.revature.bank.exceptions.AuthenticatironException;
import com.revature.bank.exceptions.InvalidRequestException;
import com.revature.bank.models.User;
import com.revature.bank.repos.UserRepository;

import static com.revature.bank.AppDriver.currentUser;

public class UserService {

    private UserRepository userRepo;

    public UserService(UserRepository repo){ this.userRepo = repo; }

    public void authenticate(String username, String password){
        if(username == null || username.trim().equals("")
            || password == null || password.trim().equals("")){
            throw new InvalidRequestException();
        }
        currentUser = userRepo.findByCredentials(username, password).orElseThrow(AuthenticatironException::new);
    }

    public void register(User newUser){
        if(!isUserValid(newUser)) throw new InvalidRequestException();

        if(userRepo.findUserByUsername(newUser.getUsrName()).isPresent()){

        }
        userRepo.save(newUser);
        currentUser = newUser;

    }

    public boolean isUserValid(User user){
        if(user == null) return false;
        if(user.getFirstName() == null || user.getFirstName().trim().equals("")) return false;
        if(user.getLastName() == null || user.getLastName().trim().equals("")) return false;
        if(user.getUsrName() == null || user.getUsrName().trim().equals("")) return false;
        if(user.getPassWord() == null || user.getPassWord().trim().equals("")) return false;
        return true;
    }

}
