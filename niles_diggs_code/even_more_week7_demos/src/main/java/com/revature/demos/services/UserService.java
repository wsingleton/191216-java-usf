package com.revature.demos.services;

import com.revature.demos.entities.AppUser;
import com.revature.demos.entities.UserRole;
import com.revature.demos.exceptions.AuthenticationException;
import com.revature.demos.exceptions.BadRequestException;
import com.revature.demos.repositories.UserRepository;
import com.revature.demos.web.dtos.Credentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepo;

    @Autowired
    public UserService(UserRepository repo) {
        super();
        this.userRepo = repo;
    }

    @Transactional(readOnly = true)
    public List<AppUser> getAllUsers() {
        return userRepo.findAll();
    }

    public AppUser autheticate(Credentials creds) {
        if (creds == null || creds.getPassword() == null || creds.getUsername() == null
        || creds.getUsername().equals("") || creds.getPassword().equals("")) {
            throw new BadRequestException("Invalid credentials provided");
        }

        AppUser retrievedUser = userRepo.findUserByCredentials(creds);

        if (retrievedUser == null) {
            throw new AuthenticationException();
        }

        return retrievedUser;
    }

    @Transactional
    public AppUser register(AppUser newUser) {

        //validation would go here... "VAaaalllIDaaationnnnn!!!!"
        newUser.setRole(UserRole.BASIC_USER);
        return userRepo.save(newUser);
    }


}
