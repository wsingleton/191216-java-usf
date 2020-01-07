package com.liberationbank.repos;

import com.liberationbank.models.Role;
import com.liberationbank.models.User;

import java.util.*;

public class UserRepository implements CrudRepository<User>{
    private Integer key;
    private HashMap<Integer, User> UserDb;

    {key=500;
        UserDb = new HashMap<>();
    UserDb.put(key, new User(key, 1838387,"Ervin", "Stewart", "Spacemvn", "Destroy@",Role.ADMIN)); key++;}

    public Optional<User> findByUserName(String username){
        for (Map.Entry<Integer, User> entry : UserDb.entrySet()){
            if (entry.getValue().getUserName().equals(username)){
                return Optional.of(entry.getValue());
            }
        }
        return Optional.empty();
    }

    public Optional<User> findByCredentials(String username, String password){
        for (Map.Entry<Integer, User> entry : UserDb.entrySet()){
            if (entry.getValue().getUserName().equals(username)
                    && entry.getValue().getPassword().equals(password))
            {
                return Optional.of(entry.getValue());
            }
        }
        return Optional.empty();
    }

    @Override
    public void save(User newObj) {
        newObj.setId(key);
        UserDb.put(key++, newObj);
    }

    @Override
    public Set<User> findAll() {
        HashSet<User> users = new HashSet<>();
        for(Map.Entry<Integer, User> entry : UserDb.entrySet()){
            users.add(entry.getValue());
        }
        return users;
    }

    @Override
    public Optional<User> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Boolean update(User updatedObj) {
        if(UserDb.get(updatedObj.getId()) == null){return false;}
        UserDb.put(updatedObj.getId(), updatedObj);
        return true;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return ( UserDb.remove(id) != null);
    }
}
