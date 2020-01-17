package com.revature.revabooks.services;

import com.revature.revabooks.exceptions.*;
import com.revature.revabooks.models.Role;
import com.revature.revabooks.models.User;
import com.revature.revabooks.repos.UserRepository;
import com.revature.revabooks.util.ConnectionFactory;
import com.revature.revabooks.util.UserSession;

import java.util.*;
import java.util.stream.Collectors;

import static com.revature.revabooks.AppDriver.app;

public class UserService {

    private UserRepository userRepo;

    public UserService(UserRepository repo) {
        super();
        this.userRepo = repo;
    }

    public void register(User newUser) {

        if (!isUserValid(newUser)) throw new InvalidRequestException();

        if (userRepo.findUserByUsername(newUser.getUsername()).isPresent()) {
            throw new ResourcePersistenceException("Username is already in use!");
        }

        newUser.setRole(Role.BASIC_MEMBER);
        userRepo.save(newUser);
        app().setCurrentSession(new UserSession(newUser, ConnectionFactory.getInstance().getConnection(newUser)));

    }

    public Set<User> getAllUsers() {

        Set<User> users;

        if (!app().getCurrentSession().isAdminOrManager()) {
            throw new AuthorizationException();
        }

        users = userRepo.findAll();

        if (users.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        return users;

    }

    public Set<User> getUsersByRole(Role role) {

        Set<User> users;

        if (role == null) {
            throw new InvalidRequestException();
        }

        if (!app().getCurrentSession().isAdminOrManager()) {
            throw new AuthorizationException();
        }

        users = userRepo.findUsersByRole(role);

        if (users.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        return users;

    }

    public User getUserByUsername(String username) {

        if (username == null || username.trim().equals("")) {
            throw new InvalidRequestException();
        }

        if (!app().getCurrentSession().isAdminOrManager()) {
            throw new AuthorizationException();
        }

        return userRepo.findUserByUsername(username).orElseThrow(ResourceNotFoundException::new);


    }

    public SortedSet<User> sortUsers(String sortCriterion, Set<User> usersForSorting) {

        SortedSet<User> users = new TreeSet<>(usersForSorting);

        switch (sortCriterion.toLowerCase()) {
            case "username":
                users = users.stream()
                        .collect(Collectors.toCollection(() -> {
                            return new TreeSet<>(Comparator.comparing(User::getUsername, String::compareTo));
                        }));
                break;
            case "first":
                users = users.stream()
                        .collect(Collectors.toCollection(() -> {
                            return new TreeSet<>(Comparator.comparing(User::getFirstName, String::compareTo));
                        }));
                break;
            case "last":
                users = users.stream()
                        .collect(Collectors.toCollection(() -> {
                            return new TreeSet<>(Comparator.comparing(User::getLastName, String::compareTo));
                        }));
                break;
            case "role":
                users = users.stream()
                        .collect(Collectors.toCollection(() -> {
                            return new TreeSet<>(Comparator.comparing(User::getRole, Enum::compareTo));
                        }));
                break;
            default:
                throw new InvalidRequestException();

        }

        return users;

    }

    public void authenticate(String username, String password) {

        if (username == null || username.trim().equals("") || password == null || password.trim().equals("")) {
            throw new InvalidRequestException();
        }

        User authUser = userRepo.findUserByCredentials(username, password).orElseThrow(AuthenticationException::new);
        app().setCurrentSession(new UserSession(authUser, ConnectionFactory.getInstance().getConnection(authUser)));

    }

    public Boolean updateProfile(User updatedUser) {

        Boolean profileUpdated;

        boolean updatingSelf = (app().getCurrentSession().getSessionUser().getId().equals(updatedUser.getId()));

        if (!updatingSelf && !app().getCurrentSession().isAdminOrManager()) {
            throw new AuthorizationException();
        }

        if (!isUserValid(updatedUser)) {
            throw new InvalidRequestException();
        }

        Optional<User> persistedUser = userRepo.findUserByUsername(updatedUser.getUsername());
        if (persistedUser.isPresent() && !persistedUser.get().getId().equals(updatedUser.getId())) {
            throw new ResourcePersistenceException("That username is taken by someone else!");
        }

        profileUpdated = userRepo.update(updatedUser);

        if (updatingSelf) app().getCurrentSession().setSessionUser(updatedUser);

        return profileUpdated;

    }

    public Boolean isUserValid(User user) {
        if (user == null) return false;
        if (user.getFirstName() == null || user.getFirstName().trim().equals("")) return false;
        if (user.getLastName() == null || user.getLastName().trim().equals("")) return false;
        if (user.getUsername() == null || user.getUsername().trim().equals("")) return false;
        if (user.getPassword() == null || user.getPassword().trim().equals("")) return false;
        return true;
    }

}
