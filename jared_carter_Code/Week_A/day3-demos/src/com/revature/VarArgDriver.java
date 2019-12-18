package com.revature;

public class VarArgDriver {

    public static void main(String[] args){


    }
    public static void varArgs(String myString, int... values){

        System.out.println(myString);

        for (int i : values){
            System.out.println(i);
        }

    }
    /*

    We can make our variable arguments as many dimensions as desired,
    just add a set of square
     */
    public static void show(int[]... my2dArray){
        for (int[] arr : my2dArray){
            for(int i :arr)
        }


    }
}
