package com.revature;

import com.revature.models.Role;
import com.revature.models.User;

public class ObjectDriver {

    public static void main(String[] args) {

        //Fully parameterized constructor call
        User myUser = new User(1, "Alice", "Anderson", "a.anderson", "p4ssword", Role.ADMIN);

        //Partially parameterized
        User otherUser = new User("Bob", "Bailey", "b.bailey", "password", Role.MEMBER);

        //No args constructor call
        User defaultUser = new User();

        System.out.println(myUser);
    }

}
