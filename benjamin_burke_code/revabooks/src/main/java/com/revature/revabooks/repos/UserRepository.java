package com.revature.revabooks.repos;
import java.util.*;


import com.revature.revabooks.models.Role;
import com.revature.revabooks.models.User;

import javax.swing.text.html.Option;

public class UserRepository implements CrudRepository<User>{

    private Integer key;
    private HashMap<Integer, User> userDb;

    {
        key=1;
        userDb = new HashMap<>();
        userDb.put(key, new User(key, "Weley", "Singleton", "wsingleton", "p4ssw0rd", Role.ADMIN)); key++;
        userDb.put(key, new User(key, "Steven", "Kelsey", "skelsey", "revature", Role.MANAGER)); key++;
        userDb.put(key, new User(key, "Blake", "Kruppa", "bkruppa", "javascript", Role.PREMIUM_MEMBER)); key++;
        userDb.put(key, new User(key, "Robert", "Connell", "rconnell", "password", Role.BASIC_MEMBER)); key++;
        userDb.put(key, new User(key, "Trevin", "Chester", "tchester", "humans", Role.ADMIN)); key++;
    }

    public Set<User> findUsersByRole(Role role){
        // A lambda expression is the inline implementation of a functional interface's one abstract method
        HashSet<User> users = new HashSet<>();
        userDb.forEach((key, value)->{
            if(value.getRole().equals(role)){
                users.add(value);
            }
        });
        return users;
    }

    public Optional<User> findUserByUsername(String username) {
        for (Map.Entry<Integer, User> entry : userDb.entrySet()){
            if (entry.getValue().getUsername().equals(username)){
                return Optional.of(entry.getValue());
            }
        }

        return Optional.empty();
    }

    public Optional<User> findUserByCrendentials (String username, String password){
        for (Map.Entry<Integer,User> entry : userDb.entrySet()){
            if(entry.getValue().getUsername().equals(username)  && entry.getValue().getPassword().equals(password))
            {
                return Optional.of(entry.getValue());
            }
        }
        return Optional.empty();
    }


    @Override
    public void save(User newObj) {
        newObj.setId(key);
        userDb.put(key++, newObj);
    }

    @Override
    public Set<User> findAll() {
        HashSet<User> users = new HashSet<>();
        //can't iterate over a map, you need to convert it to something else
        //My map of entry's
        for (Map.Entry<Integer, User> entry : userDb.entrySet()){
            users.add(entry.getValue());
        }

        return users;
    }

    @Override
    public Optional<User> findById(Integer id) {

        for(Map.Entry<Integer, User> entry : userDb.entrySet()) {
            if (entry.getValue().getId().equals(id)) {
                //wrapper around something, that's either there or nothing at all.
                return Optional.of(entry.getValue());
            }
        }

        return Optional.empty();
    }

    @Override
    public Boolean update(User updatedObj) {

        if (userDb.get(updatedObj.getId()) == null) return false;
        userDb.put(updatedObj.getId(), updatedObj);
        return true;

    }




    @Override
    public Boolean deleteById(Integer id) {
        return (userDb.remove(id) !=null);
    }
}
