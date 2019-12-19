package com.revature;

import com.revature.models.*;

public class ObjectDriver {
    public static void main(String[] args){
        User myUser = new User(1, "Alice", "Anderson", "a.anderson", "p4ssw0rd", Role.ADMIN);

        User otherUser = new User("Bob", "Bailey", "b.bailey", "p4ssw0rd", Role.MEMBER);

        User defaultUser = new User();

        System.out.println(myUser);
        System.out.println(myUser.hashCode());

        System.out.println(myUser.getFirstName());

        String userInput = "alice.anderson";
        myUser.setUsername(userInput);

        System.out.println(myUser.getFirstName());

        User aliceClone = new User(1, "Alice", "Anderson", "alice.anderson", "p4ssw0rd", Role.ADMIN);

        System.out.println(myUser == aliceClone); //checking for memory equivalence (is same object)
        System.out.println(myUser.equals(aliceClone)); //checking for value equivalence
    }
}
