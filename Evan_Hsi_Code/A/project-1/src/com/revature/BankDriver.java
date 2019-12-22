package com.revature;

import java.util.Hashtable;

public class BankDriver {

    public static void main(String[] args) {

        Bank bank = new Bank();

        //Testing output format to console

        System.out.println("Testing serialString() method: ");
        User user = new User("Evan", "Hsi", "ehsi", "12345", Role.ADMIN);
        System.out.println(user.serialString());

        //Testing reading in a user from console + lookup in the database
        int testId1;
        testId1 = bank.makeUser(System.in);
        System.out.println("Exited makeUser()");

        User user1 = bank.userBase.get(testId1);
        System.out.println(user1.serialString());


        /*
        Hashtable<Integer, Integer> hashtest = new Hashtable<>();
        hashtest.put(1, 4);
        hashtest.put(2, 5);
        System.out.println(hashtest.get(1));
        System.out.println(hashtest.get(2));
        hashtest.forEach((k, v) -> {
            System.out.println(k + ", " + v);
        } );
        /*
         */
    }
}
