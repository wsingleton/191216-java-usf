package com.revature;

import com.revature.module.Role;
import com.revature.module.User;

public class ObjectDriver {
    public static void main(String args[]){
        User myUser = new User(1, "Alice", "Andersom", "a.andderson", "pass", Role.ADMIN);
        User otherUser = new User( "Hoang", "Le", "a.andderson", "pass", Role.ADMIN);
        User defaultUser = new User();
        System.out.println(myUser);
        System.out.println(myUser.hashCode());
        System.out.println(myUser.getFirstName());
        String userInput = "hoanglee";
        otherUser.setUseName(userInput);
        System.out.println(otherUser);

        User aliceClone= new User(1, "Alice", "Andersom", "a.andderson", "pass", Role.ADMIN);
        System.out.println(myUser==aliceClone);
        System.out.println(myUser.equals(aliceClone));
    }
}
