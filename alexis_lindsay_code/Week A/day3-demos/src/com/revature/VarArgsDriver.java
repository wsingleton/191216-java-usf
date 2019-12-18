package com.revature;

public class VarArgsDriver {

    public static void main(String... args){

        varArgs("test");
        varArgs("test2", 1);
        varArgs("peanut", 1, 5);



    }

    public static void varArgs(String myString, int... values) {

        System.out.println(myString);
        for (int i: values) {

            System.out.println(i);

        }

    }

}
