package com.liberationbank.services;

import com.liberationbank.exceptions.AuthenticationException;
import com.liberationbank.exceptions.InvalidRequestException;
import com.liberationbank.exceptions.ResourcePersistenceException;
import com.liberationbank.models.Role;
import com.liberationbank.models.User;
import com.liberationbank.repos.UserRepository;

import  static com.liberationbank.AppDriver.currentUser;

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
        currentUser = userRepo.findByCredentials(username,pw).orElseThrow(() -> new AuthenticationException());
        //  currentUser = userRepo.findByCredentials(username,pw).orElseThrow(AuthenticationException::new);
    }

    public void register(User newUser){
        System.out.println("register " + newUser);
        if (!isUserValid(newUser)) throw new InvalidRequestException();
        System.out.println("user is valid");
        if ( userRepo.findByUserName(newUser.getUserName()).isPresent()){

            throw new ResourcePersistenceException("Username is already in use!");
        }
        newUser.setRole(Role.BASIC_MEMBER);
        System.out.println(newUser);
        userRepo.save(newUser);
        currentUser = newUser;
    }


    public boolean isUserValid(User user){
        if (user == null) return false;
        if (user.getFirstName() == null || user.getFirstName().trim().equals("") || !(user.getFirstName().matches("^[a-zA-Z]*$"))) return false;
        if (user.getLastName() == null || user.getLastName().trim().equals("")) return false;
        if (user.getUserName() == null || user.getUserName().trim().equals("")) return false;
        if (user.getPassword() == null || user.getPassword().trim().equals("")) return false;
        return true;
    }

    public boolean checkUserNameLength(String username){
        int maxLength =25;

        if (username.length() >= maxLength) {
            return true;
        } return false;
    }

}
