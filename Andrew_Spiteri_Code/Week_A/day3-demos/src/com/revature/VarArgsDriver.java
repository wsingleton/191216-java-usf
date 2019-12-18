package com.revature;

/*
    The main method can use variable argumants and still be considered valid syntactically.
 */

public class VarArgsDriver {
    public static void main(String[] args){
        varArgs("test");
        varArgs("test1", 1);
        varArgs("test2",1,2);
    }

    //must pass String but do not HAVE to pass any ints
    public static void varArgs(String myString, int... values){
        System.out.println(myString);
        for(int i: values){
            System.out.println(i);
        }
        System.out.println();
    }
    /*
        We can make our variable arguments as many dimensions as desired,
        just add a set of square brackets an the ellipses to pass in a multi-dimensional
        array.
     */
    public static void show(int[]... my2DArray){
        for(int i = 0; i < my2DArray.length; i++){
            for(int j = 0; j < my2DArray[i].length; j++){
                System.out.println(my2DArray[i][j]);
            }
        }

        for(int [] arr: my2DArray){
            for (int i:
                 arr) {
                System.out.println(i);
            }
        }
    }
}
