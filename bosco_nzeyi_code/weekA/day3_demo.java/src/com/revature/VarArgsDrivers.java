package com.revature;

public class VarArgsDrivers {

    public static void main(String[] args){

        varArgs("test");
        varArgs("test2", 1);
        varArgs("test3", 1,3,5);
    }

// we can ... in place of [] to declare an array. They have the same behaviors.

    public static void varArgs(String myString, int... values){

        System.out.println(myString);
        for (int i: values){
            System.out.println(i);
        }
    }
}
