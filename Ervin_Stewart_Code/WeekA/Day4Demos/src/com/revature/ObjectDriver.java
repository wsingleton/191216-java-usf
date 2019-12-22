package com.revature;

import com.revature.models.Users;
import java.util.Scanner;
import com.revature.models.Role;

public class ObjectDriver extends Users {
    public static void main(String[] args){
Scanner input = new Scanner(System.in);
        // fully paramaterized construct0r call
    Users myUser = new Users(217, "john", "doe", "Birdman", "Gatekey@1", Role.MEMBER);

    //partially parameterized constructor call
    Users otherUser = new Users("bob","Bailey","b.baily", "password", Role.MEMBER);

    //no args constructor
    Users defaultUser = new Users();

    System.out.println("Enter a username");
    String userinput = input.next();
    Users newUser = new Users();
    newUser.setUserName(userinput);
    System.out.println("Enter a firstname");
    userinput = input.next();
    newUser.setFirstName(userinput);
    // new newUser(newUser, userinput);

        createLastName(input);

        System.out.println("Enter a password");
 userinput = input.next();
 newUser.setPassword(userinput);

newUser.setId(generateId());

        System.out.println(newUser);

//    System.out.println(myUser);
//    System.out.println(myUser.hashCode());
//    System.out.println(otherUser);
//
//    Users myUserClone = new Users(217, "john", "doe", "Birdman", "Gatekey@1", Role.MEMBER);
//    System.out.println(myUser == myUserClone); // checking for memory equivalence (is same object)
//        System.out.println(myUser.equals(myUserClone)); //checking for value equivalence
//
}

    public static void createLastName(Scanner input) {
        Users newUser = ;
        String userinput;
        System.out.println("enter a lastname");
        userinput = input.next();
        newUser.setLastName(userinput);
    }

}

