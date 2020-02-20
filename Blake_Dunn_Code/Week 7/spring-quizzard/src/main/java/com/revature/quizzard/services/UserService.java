package com.revature.quizzard.services;

import com.revature.quizzard.entities.AppUser;
import com.revature.quizzard.entities.UserRole;
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
        this.userRepo = repo;
    }

    @Transactional(readOnly = true)
    public List<AppUser> getAllUsers() {
        return userRepo.findAll();
    }

    @Transactional
    public AppUser authenticate(Credentials creds) {
        return userRepo.findUserByCredentials(creds);
    }

    @Transactional
    public AppUser register(AppUser user) {

        user.setRole(UserRole.BASIC_USER);
        return userRepo.save(user);
    }

}
