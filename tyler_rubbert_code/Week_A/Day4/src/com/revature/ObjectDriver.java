package com.revature;

import com.revature.models.Role;
import com.revature.models.User;

public class ObjectDriver {

    public static void main(String[] args) {

        // Fully parameterized constructor call
        User myUser = new User(1, "Alice", "Anderson", "a.anderson", "notpassword", Role.ADMIN);

        // Partially parameterized constructor call
        User otherUser = new User("Bob", "Bailey", "b.bailey", "password", Role.MEMBER);

        // No args constructor call
        User defaultUser = new User();

        System.out.println(myUser);
        System.out.println(myUser.hashCode());

        System.out.println(myUser.getFirstName());

        myUser.setUsername("alice.anderson");

        System.out.println(myUser);

        User aliceClone = new User(1, "Alice", "Anderson", "alice.anderson", "notpassword", Role.ADMIN);

        System.out.println(myUser == aliceClone); // checking for memory equivalence (is same object?)
        System.out.println(myUser.equals(aliceClone)); // checking for value equivalence

    }

}
