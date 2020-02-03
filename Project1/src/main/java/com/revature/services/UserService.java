package com.revature.services;

import com.revature.exceptions.AuthenticationException;
import com.revature.models.User;
import com.revature.repos.UserRepository;

public class UserService {
    private UserRepository uRepo;

    private  UserService(UserRepository repository) {
        super();
        this.uRepo = repository;
    }


    public User authentication(String username, String password) throws AuthenticationException {
        if(username == null || password == null || username.trim().equals("")|| password.trim().equals("")) {
            throw new AuthenticationException();
        }

    }

    public Boolean userValidation(User user) {
        if (user == null) return false;
        if (user.getEmail() == null || user.getEmail().trim().equals("")) return false;
        if (user.getUsername() == null || user.getPassword() == null ) return false;
        if (user.getFirstName() == null || user.getLastName() == null ) return false;
        if (user.getUsername().trim().equals("") || user.getPassword().trim().equals("")) return false;
        if (user.getFirstName().trim().equals("") || user.getLastName().trim().equals("")) return false;

        return true;
    }


}
