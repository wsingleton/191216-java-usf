package com.revature;

public class VarArgsDriver {

    public static void main(String[] args) {
        varArgs("test");
        varArgs("test", 1);
        varArgs("test", 1, 2, 3);

    }

    public static void varArgs(String myString, int... values) {
        System.out.println(myString);

        for(int i : values) System.out.println(i);
    }



}
