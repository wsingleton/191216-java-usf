package com.revature;

import com.revature.models.Role;
import com.revature.models.User;

public class ObjectDriver {

    public static void main(String[] args) {

        //fully parameterized constructor call
        User myUser = new User(1, "Alice", "Anderson", "a.anderson", "p4ssw0rd", Role.ADMIN);

        //Partially parameterized constructor call
        User otherUser = new User("Bob", "Bailey", "b.bailey", "passwprd", Role.MEMBER);

        //No args constructor
        User defaultUser = new User();

        System.out.println(myUser);
    }
}
