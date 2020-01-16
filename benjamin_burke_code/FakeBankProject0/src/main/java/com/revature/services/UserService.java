package com.revature.services;
import com.revature.exceptions.AuthenticationException;
import com.revature.exceptions.InvalidRequestException;
import com.revature.exceptions.ResourcePersistenceException;
import com.revature.models.User;
import com.revature.repos.UserRepository;
import com.revature.util.ConnectionFactory;
import com.revature.util.UserSession;

import static com.revature.AppDriver.app;


public class UserService {
    private UserRepository userRepo;



    public UserService(UserRepository userRepo){
        this.userRepo=userRepo;

    }

    public void register(User newUser) {

        if (!isUserValid(newUser)) throw new InvalidRequestException();

        if (userRepo.findUserByUsername(newUser.getUsername()).isPresent()) {
            throw new ResourcePersistenceException("Username is already in use!");
        }
        userRepo.save(newUser);
        app().setCurrentSession(new UserSession(newUser, ConnectionFactory.getInstance().getConnection(newUser)));
    }


    public void authenticate(String username, String password){
        if (username== null || username.trim().equals("")
                || password == null || password.trim().equals(""))
        {
            throw new InvalidRequestException();
        }
//        userRepo.findUserByCredentials(username, password).orElseThrow(()->new AuthenticationException());
//        userRepo.findUserByCredentials(username, password).orElseThrow(AuthenticationException::new);
        User authUser = userRepo.findUserByCredentials(username, password).orElseThrow(AuthenticationException::new);
        app().setCurrentSession(new UserSession(authUser, ConnectionFactory.getInstance().getConnection(authUser)));
    }

    public boolean isUserValid(User user) {
        if(user == null) return false;

        if(user.getUsername()==null || user.getUsername().trim().equals("")) return false;
        if(user.getPassword()==null || user.getPassword().trim().equals("")) return false;

        return true;
    }
}
