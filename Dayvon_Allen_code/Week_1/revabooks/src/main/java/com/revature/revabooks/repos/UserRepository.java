package com.revature.revabooks.repos;

import com.revature.revabooks.models.Role;
import com.revature.revabooks.models.User;

import java.util.*;

public class UserRepository implements CrudRepository<User> {

    private Integer key;
    private HashMap<Integer, User> userDB;


    {
        key = 1;
        userDB = new HashMap<>();
        userDB.put(key, new User(key,"Wezley", "Singleton", "wsingleton", "p4ssw0rd", Role.ADMIN)); key++;
        userDB.put(key, new User(key,"Steve", "Kelsey", "skelsey", "testpassw0rd", Role.MANAGER)); key++;
        userDB.put(key, new User(key,"Blake", "Kruppa", "bkruppa", "password", Role.PREMIUM_MEMBER)); key++;
        userDB.put(key, new User(key,"Robert", "Connell", "rconnell", "javascript", Role.BASIC_MEMBER)); key++;
        userDB.put(key, new User(key,"Trevin", "Chester", "tchester", "humans", Role.ADMIN)); key++;
    }

    public Set<User> findUsersByRole(Role role){
        HashSet<User> users = new HashSet<>();

        userDB.forEach((key, value) -> {
            if (value.getRole().equals(role)){
                users.add(value);
            }
        });

        return users;
    }

    @Override
    public void save(User newObj) {
        newObj.setId(key);
        userDB.put(key++, newObj);
    }

    @Override
    public Set<User> findAll() {

        HashSet<User> users = new HashSet<>();
        for (Map.Entry<Integer, User> entry : userDB.entrySet()){
            users.add(entry.getValue());
        }

        return users;
    }

    public Optional<User> findUserByUsername(String username){
        for (Map.Entry<Integer, User> entry: userDB.entrySet()) {
            if(entry.getValue().getUsername().equals(username)){
                return Optional.of(entry.getValue());
            }
        }
        //avoids returning null, wrapper class
        return Optional.empty();
    }

    public Optional<User> findUserByCredentials(String username, String password){
        for (Map.Entry<Integer, User> entry: userDB.entrySet()) {
            if(entry.getValue().getUsername().equals(username) && entry.getValue().getPassword().equals(password)) {
                return Optional.of(entry.getValue());
            }
        }
        //avoids returning null, wrapper class
        return Optional.empty();
    }

    @Override
    public Optional<User> findById(Integer id) {

        for (Map.Entry<Integer, User> entry: userDB.entrySet()) {
            if(entry.getValue().getId().equals(id)){
                return Optional.of(entry.getValue());
            }
        }
        //avoids returning null, wrapper class
        return Optional.empty();
    }

    @Override
    public Boolean update(User updatedObj) {

        if(userDB.get(updatedObj.getId()) == null) {
            return false;
        }
        userDB.put(updatedObj.getId(), updatedObj);
        return true;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return userDB.remove(id) != null;
    }
}
