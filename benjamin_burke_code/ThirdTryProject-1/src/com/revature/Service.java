package com.revature;

import com.revature.models.User;

import java.util.ArrayList;

public class Service {
    static ArrayList<User>users;

    static{
        users = new ArrayList<User>();
        users.add(new User("benji", "password", 0));
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

    static User findUser(String username){
        for (User u : users) {
            if(u.getUsername().equals(username)){
                return u;
            }
        }
        return null;
    }
}
