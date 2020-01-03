package com.revature.revabooks.repos;

import com.revature.revabooks.models.Role;
import com.revature.revabooks.models.User;

import java.util.*;

public class UserRepository implements CrudRepository<User> {
    private Integer key;
    private HashMap<Integer, User> userDB;
    {
        key=1;
        userDB=new HashMap<>();
        userDB.put(key, new User(key, "Tannilen", "Reagan", "treagan", "hotcakes22", Role.ADMIN));key++;
        userDB.put(key, new User(key, "Alexander", "Reagan", "alexander.reagan", "password42", Role.ADMIN));key++;
        userDB.put(key, new User(key, "Balthaszar", "Reagan", "bz", "space", Role.BASIC_MEMBER));key++;
        userDB.put(key, new User(key, "Dipper", "Reagan", "dipsydoo", "twopurrs", Role.BASIC_MEMBER));key++;
        userDB.put(key, new User(key, "Mabel", "Reagan", "meimei", "tinyqueen", Role.PREMIUM_MEMBER));key++;
    }
    public Set<User> findUsersByRole(Role role) {
        HashSet<User> userlist=new HashSet<>();
        userDB.forEach((k, v) -> {
            if (v.getRole().equals(role)) {userlist.add(v);}
        });
        return userlist;
    }
    public Optional<User> findUserByUsername(String username) {
        for(Map.Entry<Integer, User> entry : userDB.entrySet()) {
            if (entry.getValue().getUsername().equals(username)) {
                return Optional.of(entry.getValue());
            }
        }
        return Optional.empty();
    }
    public Optional<User> findUserByCredentials(String username, String password) {
        for(Map.Entry<Integer, User> entry : userDB.entrySet()) {
            if (entry.getValue().getUsername().equals(username) && entry.getValue().getPassword().equals(password)) {
                return Optional.of(entry.getValue());
            }
        }
        return Optional.empty();
    }
    @Override
    public void save(User user) {
        user.setId(key);
        userDB.put(key, user);
        key++;
    }
    @Override
    public Set<User> findAll() {
        HashSet<User> users=new HashSet<>();
        for(Map.Entry<Integer,User> entry : userDB.entrySet()) {
            users.add(entry.getValue());
        }
        return users;
    }
    @Override
    public Optional<User> findByID(Integer id) {
        for(Map.Entry<Integer, User> entry : userDB.entrySet()) {
            if (entry.getValue().getId().equals(id)) {
                return Optional.of(entry.getValue());
            }
        }
        return Optional.empty();
    }
    @Override
    public boolean update(User user) {
        if (userDB.get(user.getId())==null) {
            return false;
        }
        userDB.put(user.getId(), user);
        return true;
    }
    @Override
    public boolean deleteByID(Integer id) {
        return (userDB.remove(id))!=null;
    }
}
