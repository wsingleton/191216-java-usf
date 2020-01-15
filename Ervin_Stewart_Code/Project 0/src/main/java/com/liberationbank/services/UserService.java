package com.liberationbank.services;

import com.liberationbank.exceptions.AuthenticationException;
import com.liberationbank.exceptions.InvalidRequestException;
import com.liberationbank.exceptions.ResourcePersistenceException;
import com.liberationbank.models.Role;
import com.liberationbank.models.User;
import com.liberationbank.repos.UserRepository;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        currentUser = userRepo.findUserByCredentials(username,pw).orElseThrow(() -> new AuthenticationException());
        //  currentUser = userRepo.findByCredentials(username,pw).orElseThrow(AuthenticationException::new);
    }

    public void register(User newUser){
        System.out.println("Registering user....");
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
        if (user.getFirstName() == null || user.getFirstName().trim().equals("") || !(user.getFirstName().matches("^[a-zA-Z]*$"))) return false;
        if (user.getLastName() == null || user.getLastName().trim().equals("") || !(user.getLastName().matches("^[a-zA-Z]*$"))) return false;
        if (user.getUserName() == null || user.getUserName().trim().equals("") || checkUserNameLength(user.getUserName())) return false;
        if (user.getPassword() == null || user.getPassword().trim().equals("") || isValidPassword(user.getPassword())) return false;
        return true;
    }

    public boolean checkUserNameLength(String username){
        int maxLength =26;

        if (username.length() >= maxLength) {
            return true;
        } return false;
    }
    public boolean isValidPassword(String password){
        int maxlength = 16;
        int minlength = 7;

        Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");

        Matcher matcher = pattern.matcher(password);

        if (matcher.matches() || password.length()<= minlength||password.length()>= maxlength) {

            return true;
        }
        return false;

    }
}
