package com.revature;
import com.revature.models.Role;
import com.revature.models.User;
public class ObjectDriver {
    public static void main(String[] args) {
        //Fully parameterized constructor call
        User administratorUser = new User(1, "Alice", "Anderson", "a.anderson", "p4ssw0rd", Role.ADMIN);
        //Partially parameterized constructor call
        User standardUser = new User("Bob", "Barker", "b.barker", "password", Role.MEMBER);
        //No args constructor call
        User defaultUser = new User();
        //Display users
        System.out.println(administratorUser);
        System.out.println(standardUser);
        System.out.println(defaultUser);
    }
}
