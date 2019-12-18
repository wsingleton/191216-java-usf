package com.revature;

public class VarArgsDriver {

    /*
        The main method can use variable arguments and still be considered valid
        syntactically
     */
    public static void main(String... args) {

       varArgs("test");
       varArgs("test2", 1);
       varArgs("test3", 1, 2, 3);

       // instantiating a 2-d array using array literals
        int[][] twoDimArr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
    }

    /*
        Variable arguments MUST be the last parameter in the parameters list!!
     */

    public static void varArgs(String myString, int... values) {
        System.out.println(myString);

        for (int i : values) {
            System.out.println(i);
        }

    }

    /*
        We can make our variable arguments as many dimenstions as desired, just add
        a set of square brackets and the ellipses to pass in a multi-dimensional
        array
     */
    public static void show(int[]... my2dArray) {

        for (int i=0; i < my2dArray.length; i++) {
            for (int j=0; j < my2dArray[i].length; j++) {
                System.out.println(my2dArray[i][j]);
            }
        }

        System.out.println("+--------------------------------+");

        for (int[] arr : my2dArray) {
            for (int i : arr) {
                System.out.println(i);
            }
        }
    }
}
