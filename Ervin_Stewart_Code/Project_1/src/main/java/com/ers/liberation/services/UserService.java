package com.ers.liberation.services;

import com.ers.liberation.exceptions.AuthenticationException;
import com.ers.liberation.exceptions.InvalidRequestException;
import com.ers.liberation.exceptions.ResourceNotFoundException;
import com.ers.liberation.exceptions.ResourcePersistenceException;
import com.ers.liberation.models.Role;
import com.ers.liberation.repos.UserRepository;
import com.ers.liberation.models.User;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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

        newUser.setRole(Role.EMPLOYEE);
        userRepo.save(newUser);

    }

    public Set<User> getAllUsers() {

        Set<User> users;

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

        return userRepo.findUserByUsername(username).orElseThrow(ResourceNotFoundException::new);


    }
    public User getUserById(int id) {
        return userRepo.findById(id).orElseThrow(ResourceNotFoundException::new);
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

    public User authenticate(String username, String password) {

        if (username == null || username.trim().equals("") || password == null || password.trim().equals("")) {
            throw new InvalidRequestException();
        }

        return userRepo.findUserByCredentials(username, password).orElseThrow(AuthenticationException::new);

    }

    public Boolean updateProfile(User updatedUser) {

        Boolean profileUpdated;

        if (!isUserValid(updatedUser)) {
            throw new InvalidRequestException();
        }

        Optional<User> persistedUser = userRepo.findUserByUsername(updatedUser.getUsername());
        if (persistedUser.isPresent() && persistedUser.get().getId() != updatedUser.getId()) {
            throw new ResourcePersistenceException("That username is taken by someone else!");
        }

        profileUpdated = userRepo.update(updatedUser);

        return profileUpdated;

    }

    public boolean isValidPassword(String password){
        int maxlength = 50;
        int minlength = 7;

        Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");

        Matcher matcher = pattern.matcher(password);

        if (matcher.matches() || password.length()<= minlength||password.length()>= maxlength) {

            return true;
        }
        return false;

    }

    public boolean checkUserNameLength(String username){
        int maxLength =50;

        if (username.length() >= maxLength) {
            return true;
        } return false;
    }

    public boolean isUserValid(User user){
        if (user == null) return false;
        if (checkFLNameLength(user.getFirstName()) ) return false;
        if (checkFLNameLength(user.getLastName())) return false;
        if (user.getUsername() == null || user.getUsername().trim().equals("") || checkUserNameLength(user.getUsername()) ) return false;
        if (user.getPassword() == null || user.getPassword().trim().equals("") || isValidPassword(user.getPassword())) return false;
        if(user.getEmail()== null || user.getEmail().trim().equals("")|| checkEmail(user.getEmail()))return false;
        return true;
    }

    public boolean checkFLNameLength(String name){
        int maxLength =100;
        int minLength = 2;
        Pattern pattern = Pattern.compile("^[a-zA-Z]*$");

        Matcher matcher = pattern.matcher(name);
        if(name ==  null || name.trim().equals("")){ return true;}
        if (!matcher.matches() || name.length()< minLength||name.length()> maxLength){return true;}

       return false;
    }

    public boolean checkEmail(String email){
        int maxLength =151;
        Pattern pattern = Pattern.compile("\\S+@\\S+\\.\\S+");
        Matcher matcher = pattern.matcher(email);

        if (email.length() >= maxLength || !matcher.matches()) {
            return true;
        } return false;
    }



    public boolean isAdmin(User user){

        if(user.getRole().getId() <2){return false;}
        return true;
    }

    public Integer adminValidation(Integer code){
        Integer newAdmin;
        switch(code) {
            case 336879:
                newAdmin = 2;
                break;
            case 547896:
                newAdmin = 3;
                break;
            default:
                newAdmin= 0;
        }

            return newAdmin;
    }
}
