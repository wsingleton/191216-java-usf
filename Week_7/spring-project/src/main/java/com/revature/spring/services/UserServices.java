package com.revature.spring.services;

import com.revature.spring.entities.AppUser;
import com.revature.spring.entities.UserRole;
import com.revature.spring.exceptions.AuthenticationException;
import com.revature.spring.exceptions.BadRequestException;
import com.revature.spring.exceptions.RessourceNotFoundException;
import com.revature.spring.repositories.UserRepository;
import com.revature.spring.web.dtos.Credentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServices {

    private UserRepository userRepo;

    @Autowired
    public UserServices(UserRepository repo) {
        super();
        this.userRepo = repo;
    }

    @Transactional(readOnly=true)
    public List<AppUser> getAllUsers() {
        return userRepo.findAll();
    }

    @Transactional(readOnly=true)
    public AppUser authenticate(Credentials creds) {

        if (creds == null || creds.getUsername() == null || creds.getPassword() == null
                || creds.getUsername().equals("") || creds.getPassword().equals(""))
        {
            throw new BadRequestException("Invalid credentials object provided!");
        }

        AppUser retrievedUser = userRepo.findUserByCredentials(creds);

        if (retrievedUser == null) {
            throw new AuthenticationException();
        }

        return retrievedUser;

    }

    @Transactional
    public AppUser register(AppUser newUser) {

        // validation would go here...

      newUser.setRole(UserRole.BASIC_USER);

      AppUser registeredUser = userRepo.save(newUser);
        return registeredUser;

    }
}