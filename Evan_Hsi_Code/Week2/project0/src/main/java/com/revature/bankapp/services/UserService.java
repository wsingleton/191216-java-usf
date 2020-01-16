package com.revature.bankapp.services;

import com.revature.bankapp.exceptions.AuthenticationException;
import com.revature.bankapp.exceptions.InvalidRequestException;
import com.revature.bankapp.exceptions.ResourcePersistenceException;
import com.revature.bankapp.models.Role;
import com.revature.bankapp.models.User;
import com.revature.bankapp.repositories.UserRepository;

import java.util.Set;

import static com.revature.bankapp.BankDriver.*;

public class UserService {

    private UserRepository userRepository;

    public UserService() {}

    public UserService(UserRepository userRepository) {this.userRepository = userRepository; }

    public void authenticate(String username, String password) {

        if (username == null || username.trim().equals("")
            || password == null || password.trim().equals(""))
            throw new InvalidRequestException();

        currentUser = userRepository.findUserByCredentials(username, password)
                .orElseThrow(AuthenticationException::new);
        userid = currentUser.getId();
    }

    public void register(User user) {
        if(!isUserValid(user)) throw new InvalidRequestException();

        if(userRepository.findUserByUserName(user.getUserName()).isPresent())
            throw new ResourcePersistenceException("Username is already in use");

        userRepository.save(user);
        currentUser = user;
        userid = user.getId();
    }

    public Set<User> findAll() {
        return userRepository.findAll();
    }

    public boolean updateUser(User user) { return userRepository.update(user); }

    public boolean deleteUserById(int id) { return userRepository.deleteById(id); }

    public boolean deleteOwn() { return userRepository.deleteOwn(); }

    private boolean isUserValid(User user) {
        if (user == null) return false;
        if (user.getFirstName() == null || user.getFirstName().trim() == "") return false;
        if (user.getLastName() == null || user.getLastName().trim() == "") return false;
        if (user.getUserName() == null || user.getUserName().trim() == "") return false;
        return true;
    }
}
