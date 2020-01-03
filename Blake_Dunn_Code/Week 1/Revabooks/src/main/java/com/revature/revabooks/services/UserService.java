package com.revature.revabooks.services;

import com.revature.revabooks.exceptions.AuthenticationException;
import com.revature.revabooks.exceptions.InvalidRequestException;
import com.revature.revabooks.exceptions.ResourcePersistenceException;
import com.revature.revabooks.models.Role;
import com.revature.revabooks.models.User;
import com.revature.revabooks.repos.UserRepository;

import static com.revature.revabooks.AppDriver.currentUser;

import java.util.Set;

public class UserService {

    private UserRepository userRepo;

    public UserService(UserRepository repo) {
        this.userRepo = repo;
    }

    public Set<User> getAllUser (){
        return null;
    }

    public Set<User> getUsersByRole (Role role) {
        return null;
    }

    public User getUserById (Integer id) {
        return null;
    }

    public User getUserByUsername (String username) {
        return null;
    }

    public void authenticate (String username, String password) {

        if (username == null || username.trim().equals("")
            || password == null || password.trim().equals(""))
        {
            throw new InvalidRequestException();
        }

//        userRepo.findUserByCredentials(username, password).orElseThrow(() -> new AuthenticationException());
        currentUser = userRepo.findUserByCredentials(username, password).orElseThrow(AuthenticationException::new);
    }

    public void register(User user) {

        if (!isUserValid(user)) throw new InvalidRequestException();

        if (userRepo.findUserByUserName(user.getUserName()).isPresent()) {
            throw new ResourcePersistenceException("Username is already in use!");
        }

        user.setRole(Role.BASIC_MEMBER);
        userRepo.save(user);
        currentUser = user;

    }

    public boolean isUserValid(User user) {
        if (user == null) return false;
        if (user.getFirstName() == null || user.getFirstName().trim().equals("")) return false;
        if (user.getLastName() == null || user.getLastName().trim().equals("")) return false;
        if (user.getUserName() == null || user.getUserName().trim().equals("")) return false;
        if (user.getPassword() == null || user.getPassword().trim().equals("")) return false;
        return true;
    }

    public boolean updateUser (User user) {
        return true;
    }

    public boolean deleteUserById (Integer id) {
        return false;
    }

    public boolean validateUserFields (User user) {
        return true;
    }
}
