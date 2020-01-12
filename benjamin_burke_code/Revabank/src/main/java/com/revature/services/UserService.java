package com.revature.services;

import com.revature.exceptions.AuthenticationException;
import com.revature.exceptions.InvalidRequestException;
import com.revature.exceptions.ResourcePersistenceException;
import com.revature.models.User;
import com.revature.repos.UserRepository;

public class UserService {

    private UserRepository userRepo;
    private AccountService accRepo;

    public UserService(UserRepository repo){
        this.userRepo=repo;

    }

    public void register(User newUser) {
        if(!isUserValid(newUser)) throw new InvalidRequestException();

        if(userRepo.findUseername(newUser.getUsername().isPresent()){
            throw  new ResourcePersistenceException("Username is Taken!");
        }

        userRepo.save(newUser);
        currentuser = newUser;
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
        if(user.getFirstName()==null || user.getFirstName().trim().equals("")) return false;
        if(user.getLastName()==null || user.getLastName().trim().equals("")) return false;
        if(user.getUsername()==null || user.getUsername().trim().equals("")) return false;
        if(user.getPassword()==null || user.getPassword().trim().equals("")) return false;

        return true;
    }




}
