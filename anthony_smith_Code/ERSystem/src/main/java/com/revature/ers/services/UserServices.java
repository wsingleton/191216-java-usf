package com.revature.ers.services;

import com.revature.ers.exceptions.*;
import com.revature.ers.models.*;
import com.revature.ers.repos.*;


import java.util.Set;

public class UserServices {

    private UserRepository userRepo;

    public UserServices(UserRepository repo){
        super();
        this.userRepo = repo;
    }

    public UserServices(){

    }


    public User getUserByID(int id){
        return userRepo.findById(id).orElseThrow(ResourceNotFoundException::new);
    }



    public Set<User> getAllUsers(){

        Set<User> users;

        users = userRepo.findAll();

        if  (users.isEmpty()){
            throw new ResourceNotFoundException();
        }

        return users;
    }


    public User getUserByUsername(String username){
        if (username == null || username.trim().equals("")){
            throw new InvalidRequestException();
        }

        return userRepo.findUserByUsername(username).orElseThrow(ResourceNotFoundException::new);
    }

    public User authenticate(String username, String password){

        if (username == null || username.trim().equals("") || password == null || password.trim().equals("")){
            throw new InvalidRequestException();
        }

        return userRepo.findUserByCredentials(username,password).orElseThrow(AuthenticationException::new);
    }


    public Boolean isUserValid(User user) {
        if (user == null) return false;
        if (user.getFirstname() == null || user.getFirstname().trim().equals("")) return false;
        if (user.getLastname() == null || user.getLastname().trim().equals("")) return false;
        if (user.getUsername() == null || user.getUsername().trim().equals("")) return false;
        if (user.getPassword() == null || user.getPassword().trim().equals("")) return false;
        if (user.getEmail() == null || user.getEmail().trim().equals("")) return false;
        return true;
    }

}
