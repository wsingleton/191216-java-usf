package com.ers.liberation.services;

import com.ers.liberation.exceptions.InvalidRequestException;
import com.ers.liberation.repos.UserRepository;
import com.ers.liberation.models.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        //currentUser = userRepo.findUserByCredentials(username,pw).orElseThrow(() -> new AuthenticationException());
        //  currentUser = userRepo.findByCredentials(username,pw).orElseThrow(AuthenticationException::new);
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
    public boolean isUserValid(User user){
        if (user == null) return false;
        if (user.getFirstName() == null || user.getFirstName().trim().equals("") || !(user.getFirstName().matches("^[a-zA-Z]*$"))) return false;
        if (user.getLastName() == null || user.getLastName().trim().equals("") || !(user.getLastName().matches("^[a-zA-Z]*$"))) return false;
        if (user.getUserName() == null || user.getUserName().trim().equals("") ) return false;
        if (user.getPassword() == null || user.getPassword().trim().equals("") || isValidPassword(user.getPassword())) return false;
        return true;
    }
}
