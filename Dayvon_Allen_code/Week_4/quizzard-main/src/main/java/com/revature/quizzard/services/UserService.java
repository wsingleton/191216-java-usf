package com.revature.quizzard.services;

import com.revature.quizzard.exceptions.AuthenticationException;
import com.revature.quizzard.exceptions.InvalidRequestException;
import com.revature.quizzard.exceptions.ResourceNotFoundException;
import com.revature.quizzard.exceptions.ResourcePersistenceException;
import com.revature.quizzard.models.Role;
import com.revature.quizzard.models.User;
import com.revature.quizzard.repos.CrudRepository;
import com.revature.quizzard.repos.UserRepository;

import java.util.*;
import java.util.stream.Collectors;

public class UserService implements CrudRepository<User> {
    private UserRepository userRepo;
    public UserService(UserRepository repo) {
        super();
        this.userRepo = repo;
    }

    public User getUserById(int id) throws ResourceNotFoundException {
        return userRepo.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public User register(User newUser) throws InvalidRequestException, ResourcePersistenceException {
        if (!isUserValid(newUser)) throw new InvalidRequestException();
        if (userRepo.findUserByUsername(newUser.getUsername()).isPresent()) {
            throw new ResourcePersistenceException();
        }
        newUser.setRole(Role.BASIC_USER);
        userRepo.save(newUser);
        return newUser;
    }
    public Set<User> getAllUsers() throws ResourceNotFoundException {
        Set<User> users;
        users = userRepo.findAll();
        if (users.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return users;
    }
    public Set<User> getUsersByRole(Role role) throws InvalidRequestException, ResourceNotFoundException {
        Set<User> users;
        if (role == null) {
            throw new InvalidRequestException();
        }
        users = userRepo.findUsersByRole(role);
        if (users.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return users;
    }
    public User getUserByUsername(String username) throws ResourceNotFoundException, InvalidRequestException {
        if (username == null || username.trim().equals("")) {
            throw new InvalidRequestException();
        }
        return userRepo.findUserByUsername(username).orElseThrow(ResourceNotFoundException::new);
    }
    public SortedSet<User> sortUsers(String sortCriterion, Set<User> usersForSorting) throws InvalidRequestException {
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
    public User authenticate(String username, String password) throws InvalidRequestException {
        if (username == null || username.trim().equals("") || password == null || password.trim().equals("")) {
            throw new InvalidRequestException();
        }
        return userRepo.findUserByCredentials(username, password).orElseThrow(AuthenticationException::new);
    }
    public Boolean updateProfile(User updatedUser) throws InvalidRequestException, ResourcePersistenceException {
        Boolean profileUpdated;
        if (!isUserValid(updatedUser)) {
            throw new InvalidRequestException();
        }
        Optional<User> persistedUser = userRepo.findUserByUsername(updatedUser.getUsername());
        if (persistedUser.isPresent() && persistedUser.get().getId() != updatedUser.getId()) {
            throw new ResourcePersistenceException();
        }
        profileUpdated = userRepo.update(updatedUser);
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

    @Override
    public void save(User newObj) {

    }

    @Override
    public Set<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> findById(int id) {
        return Optional.empty();
    }

    @Override
    public boolean update(User updatedObj) {
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
