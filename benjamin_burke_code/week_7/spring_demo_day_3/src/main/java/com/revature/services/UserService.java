package com.revature.services;


import com.revature.entitites.AppUser;
import com.revature.exception.AuthenticationException;
import com.revature.exception.BadRequestException;
import com.revature.repositories.UserRepository;
import com.revature.web.dtos.Credentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepo;

    @Autowired
    public UserService(UserRepository repo){
        super();
        this.userRepo = repo;
    }

    @Transactional(readOnly = true)
    public List<AppUser> getAllUsers(){
        return userRepo.findAll();

    }

    @Transactional(readOnly = true)
    public AppUser authenticate(Credentials creds){
        if(creds==null || creds.getUsername()==null || creds.getPassword()==null
           || creds.getUsername().equals("") || creds.getPassword().equals("")
        ) {
            throw new BadRequestException("Invalid credentials object provided");
        }

        AppUser retrievedUser = userRepo.findUserByCredentials(creds);

        if (retrievedUser == null) {
            throw new AuthenticationException();
        }
        return retrievedUser;
    }
}
