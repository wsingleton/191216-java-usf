package com.revature.revabooks.services;

import com.revature.revabooks.exceptions.AuthenticationException;
import com.revature.revabooks.exceptions.InvalidRequestException;
import com.revature.revabooks.exceptions.ResourcePersistenceException;
import com.revature.revabooks.models.Role;
import com.revature.revabooks.models.User;
import com.revature.revabooks.repos.UserRepository;

import static com.revature.revabooks.AppDriver.currentUser;

import javax.swing.plaf.IconUIResource;

public class UserService {

    private UserRepository userRepo;
    public UserService(UserRepository repo) {
        this.userRepo = repo;
    }

    public void register(User newUser) {
        if(!isUserValid(newUser)) throw new InvalidRequestException();


        if (userRepo.findUserByUsername(newUser.getUsername()).isPresent()){
            throw new ResourcePersistenceException("Username is already in use!");
        }

        newUser.setRole(Role.BASIC_MEMBER);
        userRepo.save(newUser);
        currentUser = newUser;
    }


    public void authenticate(String username, String password){
        if (username== null || username.trim().equals("")
            || password == null || password.trim().equals(""))
        {
            throw new InvalidRequestException();
        }
        userRepo.findUserByCrendentials(username, password).orElseThrow(()->new AuthenticationException());
        userRepo.findUserByCrendentials(username, password).orElseThrow(AuthenticationException::new);
        currentUser = userRepo.findUserByCrendentials(username, password).orElseThrow(AuthenticationException::new);
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
