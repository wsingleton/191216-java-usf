package com.revature;

import com.revature.models.User;

import java.util.ArrayList;

public class Service {
    static ArrayList<User> users;

    //dummy data for users?
    static {
        users = new ArrayList<>();
        users.add(new User("username1", "password", 0));
        users.add(new User("username2", "password2", 0));
        users.add(new User("username3", "password3", 100);
        users.add(new User("username4", "password4", 1000));
    }

    ArrayList<User> getAllLocal(){
        return users;
    }

    static boolean addUser(User u){
        if(findUser(u.getUsername()) != null)
            return false;

        int i = 0;
        //inserting the user into list
        for (; i<users.size();i++) {
            int curr = users.get(i).getId();
            if(i != curr){
                break;
            }
        }
        u.setId(i);
        users.add(i, u);
        DAO.syncUsers(users);
        return true;

    }
    boolean deleteUser(String username) {
        User u = findUser(username);
        if(users.remove(u)){
            DAO.syncUsers(users);
            return true;
        }
        return false;
    }
    //lets make deposits


}
