package com.revature;

public class VarArgsDriver {


    //The main method can use variable arguments and still be considered valid syntactically
    public static void main(String[] args) {

        varArgs("test");
        varArgs("test2", 1);
        varArgs("test3", 1,2,3);
    }

    /*
    Variable arguments must be the last parameter in the parameters list!
     */


    public static void varArgs(String myString, int... values){
        System.out.println(myString);

        for (int i : values) {
            System.out.println(i);
        }

    }

    /*
     we can make our variable arguments as many dimensions as desired,
     just add a set of square of a square brackets and the ellipses to pass
     in a multi-dimensional
     */
//    public static void show(int[]... my2dArray){
//
//        for(int arr : my2dArray){
//            for (int: arr){
//                System.out.println((i));
//            }
//        }
//    }
}
