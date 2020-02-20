package com.revature.quizzard.services;

import com.revature.quizzard.entities.AppUser;
import com.revature.quizzard.entities.UserRole;
import com.revature.quizzard.repositories.UserRepository;
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
    public Iterable<AppUser> getAllUsers() {
        return userRepo.findAll();
    }


    @Transactional(readOnly = true)
    public AppUser authenticate(String username, String password) {
        return userRepo.findAppUserByUsernameAndPassword(username, password);
    }

    @Transactional
    public AppUser register(AppUser user) {

        return userRepo.save(user);
    }

}
