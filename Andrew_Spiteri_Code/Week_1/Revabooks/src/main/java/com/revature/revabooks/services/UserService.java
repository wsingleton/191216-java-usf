package com.revature.revabooks.services;

import com.revature.revabooks.AppDriver;
import com.revature.revabooks.exceptions.AuthenticationException;
import com.revature.revabooks.exceptions.InvalidRequestException;
import com.revature.revabooks.exceptions.ResourcePersistenceException;
import com.revature.revabooks.models.Role;
import com.revature.revabooks.models.User;
import com.revature.revabooks.repositories.UserRepository;

import  static com.revature.revabooks.AppDriver.*;

import java.applet.AudioClip;
import java.util.Set;

public class UserService {
    private UserRepository userRepo;

    public UserService(UserRepository userRepo){
        this.userRepo = userRepo;
    }

    public Set<User> getAllUser(){
        return null;
    }

    public Set<User> getUsersByRole(Role role){
        return null;
    }

    public User getUserById(Integer id){
        return null;
    }

    public User getUserByUsername(String username){
        return null;
    }

    public void authenticate(String username, String pw){
        if(username == null || username.trim() == "" ||
        pw == null || pw.trim() == ""){
            throw  new InvalidRequestException();
        }
        //userRepo.findUserByCredentials(username,pw).orElseThrow(()->new AuthenticationException());
        currentUser = userRepo.findUserByCredentials(username,pw).orElseThrow(AuthenticationException::new);
    }

    public void register(User user){
        if(!isUserValid(user)) throw new InvalidRequestException();

        if(userRepo.findUserByUsername(user.getUsername()).isPresent()){
            throw new ResourcePersistenceException("Username is already in use!");
        }

        user.setRole(Role.BASIC_MEMBER);
        userRepo.save(user);
        currentUser = user;
    }
    public  boolean isUserValid(User user){
        if(user == null)return false;
        if(user.getFirstName() == null || user.getFirstName().trim().equals(""))return false;
        if(user.getLastName() == null || user.getLastName().trim().equals(""))return false;
        if(user.getUsername() == null || user.getUsername().trim().equals(""))return false;
        if(user.getPassword() == null || user.getPassword().trim().equals(""))return false;
        return true;
    }

    public boolean updateUser(User user){
        return false;
    }

    public boolean deleteUserById(Integer id){
        return false;
    }

    public boolean validateUserFields(User user){
        return false;
    }
}
