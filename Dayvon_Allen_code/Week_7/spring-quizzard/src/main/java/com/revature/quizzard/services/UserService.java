package com.revature.quizzard.services;

import com.revature.quizzard.entities.AppUser;
import com.revature.quizzard.entities.UserRole;
import com.revature.quizzard.exceptions.AutheticationException;
import com.revature.quizzard.exceptions.BadRequestException;
import com.revature.quizzard.repositories.UserRepository;
import com.revature.quizzard.web.dtos.Credentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;
    @Autowired
    public  UserService(UserRepository repo){
        this.userRepository = repo;
    }

    @Transactional(readOnly = true)
    public List<AppUser> getAllUsers() {
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    public AppUser authenticate(Credentials creds) {
        if(creds == null || creds.getUsername() == null || creds.getPassword() == null|| creds.getUsername().equals("") || creds.getPassword().equals("")) {
            throw new BadRequestException("Invalid creds");
        }
        AppUser retriedUser = userRepository.findUserByCredentials(creds);

        if(retriedUser == null) {
            throw new AutheticationException();
        }

        return retriedUser;
    }

    @Transactional
    public AppUser register(AppUser newUser) {
        newUser.setRole(UserRole.BASIC_USER);
        return  userRepository.save(newUser);
    }
}
