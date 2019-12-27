package com.revature;

import com.revature.models.User;

import java.util.ArrayList;

public class Service {
    static ArrayList<User>users;

    static {
        users = new ArrayList<>();
        users.add(new User("username1", "password1", 0));
        users.add(new User("username1", "password2", 540));
        users.add(new User("username1", "password3", 100));

    }

    static boolean addUser(User u) {
        if(findUser(u.getUsername()) !=null)
            return false;

        int i = 0;
        //hmmmmm
        for (; i<users.size(); i++){

        }
           users.add(i, u);
            DAO.syncUsers(users);
            return true;
    }
    boolean deleteUser(String username){
        User u = findUser(username);
        if(users.remove(u)) {
            DAO.syncUsers(users);
            return true;
        }
        return false;
    }

    static User findUser(String username){
        for(User u : users) {
            if(u.getUsername().equals(username)){
                return u;
            }
        }
        return null;
    }


}
