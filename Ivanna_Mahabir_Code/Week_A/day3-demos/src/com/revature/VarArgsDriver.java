package com.revature;

public class VarArgsDriver {

    public static void main(String[] args){

        varArgs("test");
        varArgs("test2", 1);
        varArgs("test3", 1, 2, 3);

        // instantiating a 2-d array using array literals
        int[][] twoDimArr = {
                {1, 2, 3},
                {4, 5, 8},
                {7, 8, 9}
        };

        show(twoDimArr);
    }


    public static void varArgs(String myString, int... values){
        System.out.println(myString);

        for(int i : values){
            System.out.println(i);
        }
    }

    /*
        We can make our variable arguments as many as desired, just add a
        a set of square brackets ad the ellipses to pass in a multi-dimensional
        array.
     */
    public static void show(int[]... my2dArray) {

        for(int[] arr : my2dArray){
            for(int i : arr){
                System.out.println(i);
            }
        }
    }

}
