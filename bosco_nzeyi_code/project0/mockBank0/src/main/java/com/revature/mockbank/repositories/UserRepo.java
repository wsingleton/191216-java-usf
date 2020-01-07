package com.revature.mockbank.repositories;

import com.revature.mockbank.exceptions.AuthenticationException;
import com.revature.mockbank.models.User;

import java.util.*;

public class UserRepo implements CrudRepository<User> {

    //map to save user registration inputs
   public HashMap<Integer, User> userDb = new HashMap<>();
    // keys
   public Integer key = 1;

    // overriding interface methods
    @Override
    public void save(User data) {
        userDb.put(key, data);
        key++;
    }

    @Override
    public Set<User> findAll() {
        Set<User> users = new HashSet<>();
        userDb.forEach((k,v) -> {
            users.add(v);
        });
        return users;
    }

    // find user by username and password
    public Optional<User> findUserByCredentials(String username, String password){
        for (Map.Entry<Integer, User> userData: userDb.entrySet()
             ) {
            if(userData.getValue().getUsername().equals(username)
                    && userData.getValue().getPassword().equals(password)){
                return Optional.of(userData.getValue());
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional <User> findById(Integer id) {
        for(Map.Entry<Integer, User> userData : userDb.entrySet()){
            if(userData.getValue().getId().equals(id)){
                return Optional.of(userData.getValue());
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional findByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public Boolean update(Integer id) {
        return null;
    }

    @Override
    public Boolean delete(Integer id) {
        return null;
    }
}
