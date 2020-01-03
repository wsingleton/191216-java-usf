package com.revature.revabooks.repos;

import com.revature.revabooks.models.Role;
import com.revature.revabooks.models.User;

import java.util.*;

public class UserRepository implements CrudRepository<User> {

    private Integer key;
    private HashMap<Integer, User> userDb;

    {
        key = 1;
        userDb = new HashMap<>();
        userDb.put(key, new User(key, "Blake", "Dunn", "bdunn", "p4ssw0rd", Role.ADMIN)); key ++;
        userDb.put(key, new User(key, "Ervin", "Stewart", "estewart", "gayyyyyyy", Role.MANAGER)); key ++;
        userDb.put(key, new User(key, "Corbin", "Dunn", "cdunn", "brother", Role.PREMIUM_MEMBER)); key ++;
        userDb.put(key, new User(key, "Robert", "Connell", "rconnell", "password", Role.BASIC_MEMBER)); key ++;
        userDb.put(key, new User(key, "Trevin", "Chester", "tchester", "humans", Role.ADMIN)); key ++;
    }

    // A lambda expression is the inline implementation of a functional interface's one abstract method

    public Set<User> findUsersByRole(Role role) {

        HashSet<User> users = new HashSet<>();
        userDb.forEach((key, value) -> {
            if (value.getRole().equals(role)) {
                users.add(value);
            }
        });
        return users;
    }

    public Optional<User> findUserByUserName(String username) {

        for (Map.Entry<Integer, User> entry : userDb.entrySet()) {
            if (entry.getValue().getUserName().equals(username)) {
                return Optional.of(entry.getValue());
            }
        }
        return Optional.empty();

    }

    public Optional<User> findUserByCredentials(String username, String password) {

        for (Map.Entry<Integer, User> entry : userDb.entrySet()) {
            if (entry.getValue().getUserName().equals(username) &&
                    entry.getValue().getPassword().equals(password)) {
                return Optional.of(entry.getValue());
            }
        }
        return Optional.empty();

    }


    @Override
    public void save(User newObject) {
        newObject.setId(key);
        userDb.put(key++, newObject);
    }

    @Override
    public Set<User> findAll() {

        HashSet<User> users = new HashSet<>();

        for (Map.Entry<Integer, User> entry : userDb.entrySet()) {
            users.add(entry.getValue());
        }

        return users;
    }

    @Override
    public Optional<User> findById(Integer id) {

        for (Map.Entry<Integer, User> entry : userDb.entrySet()) {
            if (entry.getValue().getId().equals(id)) {
                return Optional.of(entry.getValue());
            }
        }

        return Optional.empty();
    }

    @Override
    public Boolean update(User updateObj) {

        if (userDb.get(updateObj.getId()) == null) return false;
        userDb.put(updateObj.getId(), updateObj);
        return true;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return (userDb.remove(id) != null);
    }
}
