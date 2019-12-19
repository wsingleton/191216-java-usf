package com.revature;
import com.revature.models.User;
import com.revature.models.Role;

public class ObjectDriver {

    public static void main(String[] args){

        User myUser = new User(1, "ben", "burke", "b.man", "password", Role.ADMIN);

        User otherUser = new User("bob", "Baily", "b.baily", "password", Role.MEMBER);

        User defaultUser = new User();

        System.out.println(myUser);
        System.out.println(myUser.hashCode());

        System.out.println(myUser.getFirstName());

        String userInput = "alice.anderson";
        myUser.setUsername(userInput);

        System.out.println(myUser);

        

    }
}
