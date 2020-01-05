package com.revature.fauxbank.repos;

import com.revature.fauxbank.models.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserRepository implements CrudRepository<User> {

    private Integer key;
    private HashMap<Integer, User> userDb;

    public Optional<User> findUserByCredentials(String username, String password) {

        for (Map.Entry<Integer, User> entry : userDb.entrySet()) {
            if (entry.getValue().getUserName().equals(username) &&
                    entry.getValue().getPassword().equals(password)) {
                return Optional.of(entry.getValue());
            }
        }
        return Optional.empty();

    }

    public Optional<User> findUserByUserName(String username) {

        for (Map.Entry<Integer, User> entry : userDb.entrySet()) {
            if (entry.getValue().getUserName().equals(username)) {
                return Optional.of(entry.getValue());
            }
        }
        return Optional.empty();

    }

    @Override
    public void save(User newUser) {

        newUser.setId(key);
        userDb.put(key++, newUser);

    }

    @Override
    public Optional findById(Integer id) {

        for (Map.Entry<Integer, User> entry : userDb.entrySet()) {
            if (entry.getValue().getId().equals(id)) {
                return Optional.of(entry.getValue());
            }
        }

        return Optional.empty();
    }

    @Override
    public Boolean update(User updateUser) {

        if (userDb.get(updateUser.getId()) == null) return false;
        userDb.put(updateUser.getId(), updateUser);
        return true;

    }
}
