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

    }
}
