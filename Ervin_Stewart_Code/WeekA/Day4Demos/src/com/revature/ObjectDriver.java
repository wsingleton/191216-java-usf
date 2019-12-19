package com.revature;

import com.revature.models.Users;
import com.revature.models.Role;

public class ObjectDriver {
    public static void main(String[] args){

        // fully paramaterized construct0r call
    Users myUser = new Users(217, "john", "doe", "Birdman", "Gatekey@1", Role.MEMBER);

    //partially parameterized constructor call
    Users otherUser = new Users("bob","Bailey","b.baily", "password", Role.MEMBER);

    //no args constructor
    Users defaultUser = new Users();

    System.out.println(myUser);
    System.out.println(myUser.hashCode());
    System.out.println(otherUser);

    Users myUserClone = new Users(217, "john", "doe", "Birdman", "Gatekey@1", Role.MEMBER);
    System.out.println(myUser == myUserClone); // checking for memory equivalence (is same object)
        System.out.println(myUser.equals(myUserClone)); //checking for value equivalence
    }

}
