package com.revature;

public class VarArgsDriver {

    public static void main(String[] args) {

        varArgs("test");
        varArgs("test2", 1);
        varArgs("test3", 1,2,3);

    }
    public static void varArgs(String myString, int... values) {
        System.out.println(myString);
        for (int i : values) {
            System.out.println(i);
        }
    }

    public static void show(int[]... my2dArray) {

        for (int[] arr : my2dArray) {
            for (int i : arr) {
                System.out.println(i);
            }
        }

    }
    

}
