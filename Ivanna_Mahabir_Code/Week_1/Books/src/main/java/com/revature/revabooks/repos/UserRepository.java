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
        userDb.put(key, new User(key, "ciel", "phantomhive", "cphantom", "sebatia", Role.ADMIN)); key++;
        userDb.put(key, new User(key, "sebastian", "micheal", "demonbutler", "butler5d", Role.ADMIN)); key++;
        userDb.put(key, new User(key, "luffy", "monkey", "onepiece", "treasur3", Role.ADMIN)); key++;
        userDb.put(key, new User(key, "naruto", "uzumaki", "ramen", "kyuubi9", Role.ADMIN)); key++;
        userDb.put(key, new User(key, "sakura", "flower", "cherryBlossom", "ann0yance", Role.ADMIN)); key++;
    }

    public Set<User> findUserByRole(Role role){
        HashSet<User> users = new HashSet<>();

        //a lambda expression is the inline implementation of a functional interface's one abstract method
        userDb.forEach((key, value) -> {
            if(value.getRole().equals(role)) users.add(value);
        });
        return users;
    }
    public Optional<User> findUserByUsername(String username){
        for(Map.Entry<Integer, User> entry : userDb.entrySet()){
            if(entry.getValue().getUserName().equals(username)){
                return Optional.of(entry.getValue());
            }
        }

        return Optional.empty();
    }

    public Optional<User> findUserByCredentials(String username, String password){
        for(Map.Entry<Integer, User> entry : userDb.entrySet()){
            if(entry.getValue().getUserName().equals(username)
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
        userDb.put(key, newObj);
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

    @Override
    public Optional<User> findById(Integer id) {

        for(Map.Entry<Integer, User> entry : userDb.entrySet()){
            if(entry.getValue().getId().equals(id)){
                return Optional.of(entry.getValue());
            }
        }

        return Optional.empty();
    }

    @Override
    public Boolean update(User updatedObj) {
        if(userDb.get(updatedObj.getId()) == null) return false;
        userDb.put(updatedObj.getId(), updatedObj);
        return true;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return (userDb.remove(id) != null);
    }
}
