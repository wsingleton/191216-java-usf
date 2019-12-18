package com.revature;

public class VarArgsDriver {
    //String... is also valid
    public static void main(String[] args){

    }

    /*
        Variable arguments must be the last parameters in the parameters list.
        doesn't require that you pass anything at all and still will be valid syntactically
     */

    public static void varArgs(String myString, int... values){
        System.out.println(myString);

        for(int i : values){
            System.out.println(i);
        }
    }

    /*
    We can make our variable arguments as many dimensions as desired,
    just add a set of square brackets and the ellipses to pass in a multi-dimensional array
     */
    public static void show(int[]... my2dArray){
        for (int[] arr : my2dArray){
            for (int i : arr){
                System.out.println(i);
            }
        }
    }
}
