package com.revature;

import com.revature.models.Role;
import com.revature.models.User;

public class ObjectDriver {

    public static void main(String[] args)  {

        User myuser = new User(1, "Alice", "Anderson", "a.anderson", "p4ssw0rd", Role.ADMIN);

        User otherUser = new User("Bob", "Bailey", "b.bailey", "password", Role.MEMBER);

        User defaultUser = new User();

        System.out.println(myuser);
        System.out.println(myuser.hashCode());

        System.out.println(myuser.getFirstName());

        String userInput = "alice.anderson";
        myuser.setUsername(userInput);
        System.out.println(myuser);

        User aliceClone = new User(1, "Alice" , "Anderson", "alice.anderson", "p4ssw0rd", Role.ADMIN);
        System.out.println(myuser == aliceClone); //checking for memory equivalence (is same object?)
        System.out.println(myuser.equals(aliceClone)); // checking for value equivalence




    }
}
