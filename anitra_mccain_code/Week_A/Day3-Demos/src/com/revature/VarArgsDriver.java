package com.revature;

public class VarArgsDriver {
 /*
 * The main method can use variable arguments and still be considered valid syntactically.
 * Demonstration of polymorphism that's not method overloading and method overriding.
 * The 3 dots just mean "variable arguments"
 * Generic arguments are used to passed "types". Variable Args is used when there are a
 * variable number of things to be passed. Either going to pass nothing, one thing, or a number of things.
 * */
    public static void main(String... args) {

        varArgs("test");
        varArgs("test", 1);
        varArgs("test", 1,2,3);

        //instantiating a 2-d array using array literals
        int[][] twoDimArr = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        show(twoDimArr);
    }
    /*
    * Variable arguments MUST be the last parameter in the parameters list!
    * */
    public static void varArgs(String myString, int... values) {
        System.out.println(myString);

        for(int i: values) {
                System.out.println(i);
        }
    }
    /*
    * We can make our variable arguments as many dimensions as desired, just ass a set of
    * square brackets and the ellipse to pass in a multi-dimensional array.
    * */

    public static void show(int[]... my2dArray) {

        for(int i = 0; i < my2dArray.length; i++) {
            for(int j = 0; j< my2dArray[i].length; i++){
                System.out.println(my2dArray[i][j]);
            }
        }

        System.out.println("-----------------------------------");

        for(int[] arr : my2dArray) {
            for(int i : arr) {
                System.out.println(i);
            }
        }
    }
}
