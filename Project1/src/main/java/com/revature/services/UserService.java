package com.revature.services;

import com.revature.exceptions.AuthenticationException;
import com.revature.exceptions.InvalidRequestException;
import com.revature.exceptions.ResourceNotFoundException;
import com.revature.exceptions.ResourcePersistenceException;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.repos.UserRepository;

import java.util.Set;

public class UserService {
    private UserRepository uRepo;
    /*
     to do: make an instance of connection throughout in the user repo if necessary
     */

    public UserService(UserRepository repository) {
        super();
        this.uRepo = repository;
    }

    public void registration(User newUser) {
        if (!userValidation(newUser)) throw new InvalidRequestException();
        if (uRepo.findByUsername(newUser.getUsername()).isPresent()) {
            throw new ResourcePersistenceException();
        }
        newUser.setRole(Role.EMPLOYEE);
        uRepo.save(newUser);
    }

    public Set<User> getAllUsers(){
        Set<User> users;

        users = uRepo.findAll();

        if (users.isEmpty()) {
            throw new ResourceNotFoundException();
        } return users;
    }

    public void managerRegistration (User newUser) {
        if (!userValidation(newUser)) throw new InvalidRequestException();
        if (uRepo.findByUsername(newUser.getUsername()).isPresent()) {
            throw new ResourcePersistenceException();
        }
        newUser.setRole(Role.FINANCE_MANAGER);
        uRepo.save(newUser);
    }

    public User getUserById(int id) {
        return uRepo.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public User authentication(String username, String password) throws AuthenticationException {
        if(username == null || password == null || username.trim().equals("")|| password.trim().equals("")) {
            throw new AuthenticationException();
        }
        return uRepo.findByCreds(username, password).orElseThrow(AuthenticationException::new);
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
