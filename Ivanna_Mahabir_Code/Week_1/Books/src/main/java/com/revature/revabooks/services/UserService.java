package com.revature.revabooks.services;

import com.revature.revabooks.exceptions.AuthenticatironException;
import com.revature.revabooks.exceptions.InvalidRequestException;
import com.revature.revabooks.exceptions.ResourcePersistenceException;
import com.revature.revabooks.models.Role;
import com.revature.revabooks.models.User;
import com.revature.revabooks.repos.UserRepository;

import static com.revature.revabooks.AppDriver.currentUser;

import java.util.Set;

public class UserService {

    private UserRepository userRepo;


    public UserService(UserRepository repo){
        this.userRepo = repo;
    }

    public Set<User> getAllUser(){
     return null;
    }

    public Set<User> getUsersByRole(Role role){
        return null;
    }

    public User getUserById(Integer id){
/*        if (id == currentUser.getId() || id.equals(currentUser.getId())){
            return currentUser;
        }*/
        return null;
    }

    public User getUserByUsername(String username){

        //unique username
        //if given username == in-memory username get User
        /*if(username == currentUser.getUserName() || username.equals(currentUser.getUserName())){
            return currentUser
        }*/


        return null;
    }

    public void authenticate(String username, String password){
        if(username == null || username.trim().equals("")
            || password == null || password.trim().equals(""))
        {
            throw new InvalidRequestException();
        }

        currentUser = userRepo.findUserByCredentials(username, password).orElseThrow(AuthenticatironException::new);
    }

    public void register(User newUser){
        if(!isUserValid(newUser)) throw new InvalidRequestException();

        if(userRepo.findUserByUsername(newUser.getUserName()).isPresent()) {
            throw new ResourcePersistenceException("Username is already in use!");
        }
        newUser.setRole(Role.BASIC_MEMBER);
        userRepo.save(newUser);
        currentUser = newUser;

    }
    public boolean isUserValid(User user) {
        if (user == null) return false;
        if (user.getFirstName() == null || user.getFirstName().trim().equals("")) return false;
        if (user.getLastName() == null || user.getLastName().trim().equals("")) return false;
        if (user.getUserName() == null || user.getUserName().trim().equals("")) return false;
        if (user.getPassword() == null || user.getPassword().trim().equals("")) return false;
        return true;
    }


    boolean updateUser(User user){
        return false;
    }
    boolean deleteUserById(Integer id){
        return false;
    }

    boolean validateUserFields(User user){
        return false;
    }
}
