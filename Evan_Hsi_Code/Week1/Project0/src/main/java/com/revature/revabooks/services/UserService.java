package com.revature.revabooks.services;

import com.revature.revabooks.exceptions.AuthenticationException;
import com.revature.revabooks.exceptions.InvalidRequestException;
import com.revature.revabooks.exceptions.ResourcePersistanceException;
import com.revature.revabooks.models.Role;
import com.revature.revabooks.models.User;
import com.revature.revabooks.repositories.UserRepository;
import static com.revature.revabooks.AppDriver.*;

import java.util.Set;

public class UserService {

    private UserRepository userRepo;

    public UserService() {}

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }


    public void authenticate(String username, String password) {

        //System.out.println("userv authenticate");

        if (username == null || username.trim().equals("")
            || password == null || password.trim().equals(""))
            throw new InvalidRequestException();


        currentUser = userRepo.findUserByCredentials(username, password).orElseThrow(AuthenticationException::new);
    }

    public void register(User user) {
        if(!isUserValid(user)) throw new InvalidRequestException();

        if(userRepo.findUserByUserName(user.getUsername()).isPresent())
            throw new ResourcePersistanceException("Username is already in use");

        user.setRole(Role.BASIC_MEMBER);
        userRepo.save(user);
        currentUser = user;

    }

    public boolean updateUser(User user) {
        return userRepo.update(user);
    }

    public boolean deleteUserById(int id) {
        return userRepo.deleteById(id);
    }

    public boolean isUserValid(User user) {
        if (user == null) return false;
        if (user.getFirstName() == null || user.getFirstName().trim() == "") return false;
        if (user.getLastName() == null || user.getLastName().trim() == "") return false;
        if (user.getUsername() == null || user.getUsername().trim() == "") return false;
        if (user.getPassword() == null || user.getPassword().trim() == "") return false;
        return true;
    }

    public void printUsers() {
        for(User user:userRepo.findAll()) {
            System.out.println(user.toString());
        }
    }

}
