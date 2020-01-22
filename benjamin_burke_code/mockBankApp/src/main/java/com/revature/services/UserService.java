package com.revature.services;

import com.revature.exceptions.*;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.repos.UserRepository;


import  static com.revature.AppDriver.currentUser;


public class UserService {
    private UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        super();
        this.userRepo = userRepo;
    }

    public void register(User newUser)  {

        if (!isUserValid(newUser)) throw new InvalidRequestException();

        if (userRepo.findUserByUsername(newUser.getUsername()).isPresent()) {
            throw new ResourcePersistentException("Username unavailable");
        }

        newUser.setRole(Role.BASIC_MEMBER);
//        app().setCurrentSession(new UserSession(newUser, ConnectionFactory.getInstance().getConnection(newUser)));
        userRepo.save(newUser);
        currentUser = newUser;
    }

//    public Set<User> getAllUsers() {
//
//        Set<User> users;
//
//        users = userRepo.findAll();
//
//        if (users.isEmpty()) {
//            throw new ResourceNotFoundException();
//        }
//
//        return users;
//
//    }
//
//    public User getUserByUsername(String username) {
//
//        if (username == null || username.trim().equals("")) {
//            throw new InvalidRequestException();
//        }
//
//        return userRepo.findUserByUsername(username).orElseThrow(ResourceNotFoundException::new);
//
//    }

    public void authenticate(String username, String password) {

        if (username == null || username.trim().equals("") || password == null || password.trim().equals("")) {
            throw new InvalidRequestException();
        }

        currentUser = userRepo.findUserByCredentials(username, password).orElseThrow(() -> new AuthenticationException());

    }

//    public Boolean updateProfile(User updatedUser) {
//
//        boolean profileUpdated;
//
//        boolean updating = (app().getCurrentSession().getSessionUser().getUserId().equals(updatedUser.getUserId()));
//
//        if (!updating) {
//            throw new AuthorizationException();
//        }
//
//        if (!isUserValid(updatedUser)) {
//            throw new InvalidRequestException();
//        }
//
//        Optional<User> persistedUser = userRepo.findUserByUsername(updatedUser.getUsername());
//        if (persistedUser.isPresent() && !persistedUser.get().getUserId().equals(updatedUser.getUserId())) {
//            throw new ResourcePersistentException("Username is taken");
//        }
//
//        profileUpdated = userRepo.update(updatedUser);
//
//        if (updating) app().getCurrentSession().setSessionUser(updatedUser);
//
//        return profileUpdated;
//    }

    public boolean isUserValid(User user){
        if (user == null) return false;
        if (user.getFirstName() == null || user.getFirstName().trim().equals("") ) return false;
        if (user.getLastName()== null || user.getLastName().trim().equals("") ) return false;
        if (user.getUsername() == null || user.getUsername().trim().equals("") ) return false;
        if (user.getPassword() == null || user.getPassword().trim().equals("")) return false;
        return true;
    }
}

