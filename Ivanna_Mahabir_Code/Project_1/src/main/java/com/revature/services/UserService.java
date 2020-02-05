package com.revature.services;

import com.revature.exceptions.*;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.repos.UserRepository;

import java.util.*;
import java.util.regex.Pattern;

public class UserService {

    private UserRepository userRepo;

    public UserService(UserRepository repo) {
        super();
        this.userRepo = repo;
    }

    public void register(User newUser){
        if(isUserValid(newUser)) throw new InvalidRequestException();

        if(userRepo.findUserByUsername(newUser.getUser_name()).isPresent()){
            throw new ResourcePersistanceException("Username is already in use!");
        }
        newUser.setRole(Role.EMPLOYEE);
        userRepo.save(newUser);
    }

    public static boolean uCase(char ch) {
        ch = Character.toUpperCase(ch);
        return ch >= 'A' && ch <= 'Z';
    }

    //test for a number
    public static boolean nCase(String passwor) {
        return Pattern.compile("[0-9]").matcher(passwor).find();
    }

    //Validation for username and password
    public static boolean validate(String arg) {
        if (arg.length() >= 8 && arg.length() <= 15) {
            for (int i = 0; i < arg.length(); i++) {
                char ch = arg.charAt(i);
                if (uCase(ch)) {
                    if (nCase(arg)) {
                        return true;
                    }

                }
            }
        }
        return false;
    }

    public User authenticate(String username, String password){
        if(username == null || username.trim().equals("")
        || password == null || password.trim().equals("")) {
            throw new InvalidRequestException();
        }
            return userRepo.findByCredentials(username, password).orElseThrow(AuthenticationException::new);
    }

    public User getUserById(Integer id){
    if (id == null){
        throw new InvalidRequestException();
    }
        return userRepo.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public User getUserByUsername(String username){
        if(username == null || username.trim().equals("")){
            throw new InvalidRequestException();
        }
        return userRepo.findUserByUsername(username).orElseThrow(ResourceNotFoundException::new);
    }


    public Set<User> getAllUsers(){
        Set<User> users;
        users = userRepo.findAll();
        if(users.isEmpty()){
            throw new ResourceNotFoundException();
        }
        return users;
    }

    public boolean isUserValid(User user){
        if(user == null) return false;
        if(user.getFirst_name() == null || user.getFirst_name().trim().equals("")) return false;
        if(user.getLast_name() == null || user.getLast_name().trim().equals("")) return false;
        if(user.getUser_name() == null || user.getUser_name().trim().equals("")) return false;
        if(user.getPass_word() == null || user.getPass_word().trim().equals("")) return false;
        return true;
    }

}
