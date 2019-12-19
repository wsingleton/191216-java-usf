package com.revature;

import com.revature.models.Role;
import com.revature.models.User;

public class ObjectDriver {

    public static void main(String[] args){

        // fully parameterized constructor call
        User myUser = new User(1, "Alice", "Anderson", "a.anderson", "pass4word", Role.ADMIN);

        //Partially parameterized constructor call
        User otherUser = new User("bob", "bailey", "b.bailey", "password", Role.MEMBER);

        //No args constructor call
        User defaultUser = new User();

        System.out.println(myUser);
        System.out.println(myUser.hashCode());



    }
}
