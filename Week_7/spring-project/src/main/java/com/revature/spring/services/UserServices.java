package com.revature.spring.services;

import com.revature.spring.entities.AppUser;
import com.revature.spring.exceptions.AuthenticationException;
import com.revature.spring.exceptions.BadRequestException;
import com.revature.spring.repositories.UserRepository;
import com.revature.spring.web.dtos.Credentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class UserServices {

    private UserRepository userRepository;

    @Autowired
    public UserServices(UserRepository repo) {
        super();
        this.userRepository = repo;
    }

    @Transactional(readOnly=true)
    public List<AppUser> getAllUsers(){
        return userRepository.findAll();
    }

    public AppUser getByCredentials(Credentials creds){
        if(creds ==null || creds.getUsername() == null || creds.getPassword() == null
            || creds.getUsername().equals("") || creds.getPassword().equals(""))
        {
            throw new BadRequestException();
        }

        AppUser retrievedUser = userRepository.findUserByCredentials(creds);

        if(retrievedUser == null){
            throw new AuthenticationException();
        }

        return retrievedUser;
    }

    @Transactional(readOnly = true)
    public AppUser register(AppUser newUser){

        // some sort of newUser validation needed before saving.
        return userRepository.save(newUser);
    }
}
