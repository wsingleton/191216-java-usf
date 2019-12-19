package com.revature;

import com.revature.models.User;

public class ObjectDriver {

    public static void main(String[] args) {
//Fully parameterized constructor call
        User myUser = new User(1, "Alice", "Anderson", "a.anderson", "p4ssw0rd", Role.ADMIN);
       //partially parameterized constructor call
        User otherUser = new User("Bob", " Bailey", "b.bailey", "password", Role.MEMBER);
        // no args constructor call
        User defaultUser = new User();


        System.out.println(myUser);
        System.out.println(myUser.getFirstName());

        String userInput = "alice.anderson";
        myUser.setUsername(userInput);

        System.out.println(myUser);

        User aliceClone =new User(1,"Alice", "Anderson", "alice.anderson", "p4ssw0rd", Role.ADMIN);
        System.out.println(myUser == aliceClone); //checking for memory equivalence (is this the same object)
        System.out.println(myUser.equals(aliceClone)); //checking for






    }
}
