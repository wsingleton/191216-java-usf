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
        userDb.put(key, new User(key, "Wezley", "Singleton", "wsingleton", "p4ssw0rd", Role.ADMIN)); key++;
        userDb.put(key, new User(key, "Steven", "Kelsey", "skelsey", "revature", Role.MANAGER)); key++;
        userDb.put(key, new User(key, "Blake", "Kruppa", "bkruppa", "javascript", Role.PREMIUM_MEMBER)); key++;
        userDb.put(key, new User(key, "Robert", "Connell", "rconnell", "password", Role.BASIC_MEMBER)); key++;
        userDb.put(key, new User(key, "Trevin", "Chester", "tchester", "humans", Role.ADMIN)); key++;
        //userDb.forEach((k,v) -> System.out.println(v.toString()));
    }


    @Override
    public void save(User u) {
        u.setId(key);
        userDb.put(key, u);
        key++;
    }

    @Override
    public Set<User> findAll() {
        HashSet<User> allSet = new HashSet<User>();
        userDb.forEach((k,v) -> allSet.add(v));
        return allSet;
    }

    @Override
    public Optional<User> findById(int id) {
        if(!userDb.containsKey(id)) return Optional.empty();
        return Optional.of(userDb.get(id));
    }

    @Override
    public boolean update(User u) {
        if(!userDb.containsKey(u.getId())) return false;
        userDb.put(u.getId(), u);
        return true;
    }

    @Override
    public boolean deleteById(int id) {
        return (userDb.remove(id) != null);
    }

    public Set<User> findUsersByRole(Role role) {

        HashSet<User> allSet = new HashSet<User>();
        userDb.forEach((k,v) ->  { if(v.getRole().equals(role)) allSet.add(v); });
        return allSet;
    }

    public Optional<User> findUserByUserName(String username) {
        for (Map.Entry<Integer, User> entry : userDb.entrySet()) {
            if (entry.getValue().getUsername().equals(username)) {
                return Optional.of(entry.getValue());
            }
        }
        return Optional.empty();
    }

    public Optional<User> findUserByCredentials(String username, String pw) {
       for(Map.Entry<Integer, User> entry : userDb.entrySet()) {

           if (entry.getValue().getUsername().equals(username)
               && entry.getValue().getPassword().equals(pw))  {
               return Optional.of(entry.getValue());
           }
       }
       return Optional.empty();
    }
}
