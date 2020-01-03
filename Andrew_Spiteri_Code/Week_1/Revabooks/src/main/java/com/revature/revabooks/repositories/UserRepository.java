package com.revature.revabooks.repositories;

import com.revature.revabooks.models.Role;
import com.revature.revabooks.models.User;

import java.util.*;

public class UserRepository implements CrudRepository<User> {
    private Integer key;
    private HashMap<Integer, User> userDb;

    {
        key = 1;
        userDb = new HashMap<>();
        userDb.put(key, new User(key, "Andrew", "Spiteri", "wsingleton", "password", Role.ADMIN));
        key++;
        userDb.put(key, new User(key, "Robert", "Siporin", "rSiporin", "password", Role.MANAGER));
        key++;
        userDb.put(key, new User(key, "John", "Doe", "jDoe", "password", Role.PREMIUM_MEMBER));
        key++;
        userDb.put(key, new User(key, "Mike", "Jones", "mJones", "password", Role.PREMIUM_MEMBER));
        key++;
        userDb.put(key, new User(key, "Brian", "Riedy", "bRiedy", "password", Role.BASIC_MEMBER));
        key++;
    }

    public Set<User> findUserByRole(Role role){
        HashSet<User> users = new HashSet<>();
        userDb.forEach((key, value) -> {
            if(value.getRole().equals(role)){
                users.add(value);
            }
        });

        return users;
    }

    public Optional<User> findUserByUsername(String username){
        for(Map.Entry<Integer, User> entry: userDb.entrySet()){
            if(entry.getValue().getUsername().equals(username)){
                return Optional.of(entry.getValue());
            }
        }
        return Optional.empty();
    }

    public Optional<User> findUserByCredentials(String username, String pw){
        for(Map.Entry<Integer, User> entry: userDb.entrySet()){
            if(entry.getValue().getUsername().equals(username)
                    && entry.getValue().getPassword().equals(pw))
            {
                return Optional.of(entry.getValue());
            }
        }
        return Optional.empty();
    }


    @Override
    public void save(User user) {
        user.setId(key);
        userDb.put(key, user);
        key++;
    }

    @Override
    public Set<User> findAll() {
        HashSet<User> users = new HashSet<>();
        for(Map.Entry<Integer, User> entry : userDb.entrySet()){
            users.add(entry.getValue());
        }

        return users;
    }

    //Optional is a way of avoiding returning nulls, no NullPointerException
    @Override
    public Optional<User> findById(Integer id) {
        for(Map.Entry<Integer, User> entry: userDb.entrySet()){
            if(entry.getValue().getId().equals(id)){
                return Optional.of(entry.getValue());
            }
        }
        return Optional.empty();
    }

    @Override
    public Boolean update(User user) {
        if(userDb.get(user.getId()) == null){
            return false;
        }
        userDb.put(user.getId(), user);
        return true;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return  (userDb.remove(id) != null);
    }
}
