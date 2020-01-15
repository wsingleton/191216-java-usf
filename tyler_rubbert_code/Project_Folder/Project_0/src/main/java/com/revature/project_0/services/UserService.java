package com.revature.project_0.services;

import com.revature.project_0.exceptions.*;
import com.revature.project_0.models.User;
import com.revature.project_0.repos.UserRepository;
import com.revature.project_0.util.ConnectionFactory;
import com.revature.project_0.util.UserSession;

import java.util.*;
import java.util.stream.Collectors;

import static com.revature.project_0.AppDriver.app;

public class UserService {

    private UserRepository userRepo;

    public UserService(UserRepository repo) {
        super();
        this.userRepo = repo;
    }

    public void register(User newUser)  {

        if (!isUserValid(newUser)) throw new InvalidRequestException();

        if (userRepo.findUserByUsername(newUser.getUsername()).isPresent()) {
            throw new ResourcePersistentException("Username unavailable");
        }

        userRepo.save(newUser);
        app().setCurrentSession(new UserSession(newUser, ConnectionFactory.getInstance().getConnection(newUser)));
    }

    public Set<User> getAllUsers() {

        Set<User> users;

        users = userRepo.findAll();

        if (users.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        return users;

    }

    public User getUserByUsername(String username) {

        if (username == null || username.trim().equals("")) {
            throw new InvalidRequestException();
        }

        return userRepo.findUserByUsername(username).orElseThrow(ResourceNotFoundException::new);

    }

    public void authenticate(String username, String password) {

        if (username == null || username.trim().equals("") || password == null || password.trim().equals("")) {
            throw new InvalidRequestException();
        }

        User authUser = userRepo.findUserByCredentials(username, password).orElseThrow(AuthenticationException::new);
        app().setCurrentSession(new UserSession(authUser, ConnectionFactory.getInstance().getConnection(authUser)));

    }

    public Boolean updateProfile(User updatedUser) {

        boolean profileUpdated;

        boolean updatingSelf = (app().getCurrentSession().getSessionUser().getUserId().equals(updatedUser.getUserId()));

        if (!updatingSelf) {
            throw new AuthorizationException();
        }

        if (!isUserValid(updatedUser)) {
            throw new InvalidRequestException();
        }

        Optional<User> persistedUser = userRepo.findUserByUsername(updatedUser.getUsername());
        if (persistedUser.isPresent() && !persistedUser.get().getUserId().equals(updatedUser.getUserId())) {
            throw new ResourcePersistentException("That username is taken by someone else!");
        }

        profileUpdated = userRepo.update(updatedUser);

        if (updatingSelf) app().getCurrentSession().setSessionUser(updatedUser);

        return profileUpdated;
    }

    public Boolean isUserValid(User user) {
        if (user == null) return false;
        if (user.getFirstName() == null || user.getFirstName().trim().equals("")) return false;
        if (user.getLastName() == null || user.getFirstName().trim().equals("")) return false;
        if (user.getUsername() == null || user.getUsername().trim().equals("")) return false;
        if (user.getPassword() == null || user.getPassword().trim().equals("")) return false;
        return true;
    }
}
