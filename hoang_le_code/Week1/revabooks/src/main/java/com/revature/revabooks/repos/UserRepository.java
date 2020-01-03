package com.revature.revabooks.repos;

import com.revature.revabooks.models.Role;
import com.revature.revabooks.models.User;

import java.util.*;

public class UserRepository implements CrudRepository<User> {
    private Integer key;
    private HashMap<Integer,User> userDb;

    {
        key = 1 ;
        userDb = new HashMap<>();
        userDb.put(key,new User(key,"Le","hoang","hl","pass", Role.ADMIN));key++;
        userDb.put(key,new User(key,"Le1","hoang1","hl1","pass1", Role.MANAGER));key++;
        userDb.put(key,new User(key,"Le2","hoang2","hl2","pass2", Role.PREMIUM_MEMBER));key++;
        userDb.put(key,new User(key,"Le3","hoang3","hl3","pass3", Role.BASIC_MEMBER));key++;
        userDb.put(key,new User(key,"Le4","hoang4","hl4","pass4", Role.ADMIN));key++;
        userDb.put(key,new User(key,"Le5","hoang5","hl5","pass5", Role.ADMIN));key++;

    }

       public Set<User> findUSersByRole(Role role){
        HashSet<User> users = new HashSet<>();


        // a lamda expresstion is the inline implementation of a funtional interface's one abstract method
        userDb.forEach((key,value) -> {
            if (value.getRole().equals(role)){
                users.add(value);
            }
        });


        return users;
    }

    public Optional<User> findUserByUsername(String username){
        for (Map.Entry<Integer,User> entry : userDb.entrySet()){
            if(entry.getValue().getUsername().equals(username)){
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
        userDb.put(key++,newObj);

    }

    @Override
    public Set<User> findAll() {
        HashSet<User> users = new HashSet<>();

        // for each entry in my map entry set
        for(Map.Entry<Integer,User> entry: userDb.entrySet()){
            users.add(entry.getValue());

        }

        return users;
    }

    @Override
    public Optional<User> findById(Integer id) {

        for (Map.Entry<Integer,User> entry : userDb.entrySet()){
            if(entry.getValue().getId().equals(id)){
                return Optional.of(entry.getValue());
            }
        }

        return Optional.empty();

    }

    @Override
    public Boolean update(User updatedObj) {

        if(userDb.get(updatedObj.getId()) == null){
            return false;
        }
        userDb.put(updatedObj.getId(),updatedObj);

        return true;
    }

    @Override
    public Boolean deleteById(Integer id) {

        // this one will look better

        User u = userDb.remove(id);
        if(u == null){
            return false;
        }
        else {
            return true;
        }

        // this one will look better
       // return (userDb.remove(id) != null);
    }
}