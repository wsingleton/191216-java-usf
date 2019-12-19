package com.revature.util;

import com.revature.models.User;
import com.revature.models.Role;

public class ObjectDriver{

    public static void main(String[] args){

    User myUser = new User(1, "Alice", "Anderson", "a.anderson", "p4ssword", Role.ADMIN);

    User  otherUser = new User("Bob", "Bailey", "b.bailey", "password", Role.MEMBER);

    User defaultUser = new User();

    System.out.println(myUser);
    }
}
