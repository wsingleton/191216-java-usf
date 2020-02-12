package com.revature.quizzard.services;

import com.revature.quizzard.entities.AppUser;
import com.revature.quizzard.exceptions.AuthenticationException;
import com.revature.quizzard.exceptions.BadRequestException;
import com.revature.quizzard.repositories.UserRepository;
import com.revature.quizzard.web.dtos.Credentials;
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
        this.userRepo=repo;
    }
    @Transactional(readOnly = true)
    public List<AppUser> getAllUsers() {
        return userRepo.findAll();
    }
    @Transactional(readOnly = true)
    public AppUser authenticate(Credentials c) {
        if (c==null || c.getUsername()==null || c.getPassword()==null || c.getUsername()=="" || c.getPassword()=="") {
            throw new BadRequestException();
        }

        AppUser u=userRepo.findUserByCredentials(c);
        if(u==null){
            throw new AuthenticationException();
        }
        return u;
    }
}
