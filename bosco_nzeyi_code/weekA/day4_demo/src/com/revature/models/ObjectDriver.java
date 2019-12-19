package com.revature.models;

public class ObjectDriver {

    public static void main (String[] args){

        // as we created different constructors, its possible to override them by passing different parameters

//        User myUser = new User("Bobo", "Boss", "Boboboss", "1233", Role.ADMIN );
//        User otherUser = new User(1, "Ervin", "nana", "erna", "paswd", Role.USER );
//
        User defaultUser = new User();
////
//        System.out.println(myUser);
//        System.out.println(otherUser);
        System.out.println(defaultUser.hashCode());


    }
}