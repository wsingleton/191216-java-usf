package com.revature.revabooks.repos;

import com.revature.revabooks.models.Role;
import com.revature.revabooks.models.User;

import java.util.*;

public class UserRepository implements CrudRepository<User> {

    private Integer key;
    private HashMap<Integer, User> UserDb;

    {key =1;
    UserDb = new HashMap<>();
    UserDb.put(key, new User(key, "Ervin", "Stewart", "Spacemvn", "Destroy@", Role.ADMIN)); key++;
    UserDb.put(key, new User(key, "Brian", "Kuznetz", "FoolBoyB", "370$Z", Role.MANAGER)); key++;
    UserDb.put(key, new User(key, "Tyler", "Macleish", "Unitard777", "PepperC@t", Role.PREMIUM_MEMBER)); key++;
    UserDb.put(key, new User(key, "Blake", "Dunn", "BDunn333", "BigWangG@ng", Role.BASIC_MEMBER)); key++;
    UserDb.put(key, new User(key, "Bosco", "AfricanLastname", "TheMotherLand", "TheBlackerTheBerry$", Role.ADMIN)); key++;}

    public Set<User> findUsersByRole(Role role){
        HashSet<User> users = new HashSet<>();
        //example of a lambda expression
        UserDb.forEach((key, value) -> {
            if(value.getRole().equals(role)){
                users.add(value);
            }
        });
        return users;
    }

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
        for (Map.Entry<Integer, User> entry : UserDb.entrySet()){
            if (entry.getValue().getId().equals(id)){
                return Optional.of(entry.getValue());
            }
        }
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
