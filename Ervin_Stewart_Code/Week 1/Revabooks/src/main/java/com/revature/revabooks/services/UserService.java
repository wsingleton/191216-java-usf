package com.revature.revabooks.services;

import com.revature.revabooks.exceptions.AuthenticationException;
import com.revature.revabooks.exceptions.InvalidRequestException;
import com.revature.revabooks.exceptions.ResourcePersistenceException;
import com.revature.revabooks.models.Role;
import com.revature.revabooks.models.User;
import com.revature.revabooks.repos.UserRepository;

import  static com.revature.revabooks.AppDriver.currentUser;
import java.util.Set;

public class UserService {
    private UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }



    public void authenticate(String username,String pw){

        if(username == null || username.trim().equals("")
                || pw == null || pw.trim().equals("")){
            throw new InvalidRequestException();
        }
        currentUser = userRepo.findUserByCredentials(username,pw).orElseThrow(() -> new AuthenticationException());
        //  currentUser = userRepo.findByCredentials(username,pw).orElseThrow(AuthenticationException::new);
    }

    public void register(User newUser){
        if (!isUserValid(newUser)) throw new InvalidRequestException();
        if ( userRepo.findByUserName(newUser.getUserName()).isPresent()){
            throw new ResourcePersistenceException("Username is already in use!");
        }
        newUser.setRole(Role.BASIC_MEMBER);
        userRepo.save(newUser);
        currentUser = newUser;
    }


    public boolean isUserValid(User user){
        if (user == null) return false;
        if (user.getFirstName() == null || user.getFirstName().trim().equals("")) return false;
        if (user.getLastName() == null || user.getLastName().trim().equals("")) return false;
        if (user.getUserName() == null || user.getUserName().trim().equals("")) return false;
        if (user.getPassword() == null || user.getPassword().trim().equals("")) return false;
        return true;
    }
}
