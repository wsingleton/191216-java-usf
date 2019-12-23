package com.revature;

import com.revature.models.User;

import java.util.HashSet;
import java.util.Set;

public class CollectionDriver {

    public static void main(String[] args) {

        /*
        Set


         */
        Set <User> userSet = new HashSet<>();
        User u = new User(1, "wsingleton", "p4ssword");
        userSet.add(u);
        userSet.add(new User(2, "skelsey", "password"));
        userSet.add(new User(3, "rconnell", "roll-tide"));
        userSet.add(new User(13, "test", "test-pw"));
        userSet.add(u);

        for (User user : userSet) {

            System.out.println(user);
        }


    }

}
