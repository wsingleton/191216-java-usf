package com.revature;

import com.revature.models.Role;
import com.revature.models.User;

public class ObjectDriver {

    public static void main(String[] args){

        User myUser = new User(1, "Alice", "Anderson", "a.anderson", "password1", Role.ADMIN);

        User otherUser = new User("Bob", "Bailey", "b.bailey", "password", Role.MEMBER);

        User defaultUser = new User();

        System.out.println(myUser);
        System.out.println(myUser.hashCode());
        System.out.println(otherUser.getFristName());
    }
}
