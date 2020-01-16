package com.revature.mockbank.services;

import com.revature.mockbank.AppDriver;
import com.revature.mockbank.exceptions.*;
import com.revature.mockbank.models.Role;
import com.revature.mockbank.models.User;
import com.revature.mockbank.repositories.AccountRepo;
import com.revature.mockbank.repositories.UserRepo;

import java.util.Set;

import static com.revature.mockbank.AppDriver.currentUser;
import static com.revature.mockbank.repositories.UserRepo.*;

public class UserService {

    private UserRepo userRepo;
    private AccountRepo accountRepo;

    public UserService(UserRepo repo, AccountRepo accountRepo) {
        this.userRepo = repo;
        this.accountRepo = accountRepo;
    }
    public UserService(UserRepo repo) {
        this.userRepo = repo;
    }

    public void register(User newUser) {

        if (!isUserValid(newUser)) throw new InvalidRequestException();

        if (userRepo.findByUsername(newUser.getUsername()).isPresent()) {
            throw new ResourcePersistenceException("Username is already in use!");
        }

        //newUser.setRole(Role.CLIENT);
        userRepo.save(newUser);
        currentUser = registeredUser;
        int currentUserId = currentUser.getId();
        accountRepo.findAllAccounts(currentUserId);

    }

    public Set<User> findAllUsers(String role) {

        Set<User> users;

        if (!(role.equals("Admin"))) {
            throw new AuthorizationException();
        }
        users = userRepo.findAll();

        if (users.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return users;
    }

    public void authenticate(String username, String password) {

        if (username == null || username.trim().equals("")
                || password == null || password.trim().equals(""))
        {
            throw new InvalidRequestException();
        }

        currentUser = userRepo.findUserByCredentials(username, password).orElseThrow(AuthenticationException::new);
    }

    public boolean isUserValid(User user) {
        if (user == null) return false;
        if (user.getFirstName() == null || user.getFirstName().trim().equals("")) return false;
        if (user.getLastName() == null || user.getLastName().trim().equals("")) return false;
        if (user.getUsername() == null || user.getUsername().trim().equals("")) return false;
        if (user.getPassword() == null || user.getPassword().trim().equals("")) return false;
        return true;
    }

}
