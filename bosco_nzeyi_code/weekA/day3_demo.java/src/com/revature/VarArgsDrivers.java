package com.revature;

public class VarArgsDrivers {

    public static void main(String[] args){

        varArgs("test");
        varArgs("test2", 1);
        varArgs("test3", 1,3,5);

        int[][] test = {{2,4}, {3,9}};
        show(test);
    }

// we can ... in place of [] to declare an array. They have the same behaviors.

    public static void varArgs(String myString, int... values){

        System.out.println(myString);
        for (int i: values){
            System.out.println(i);
        }
    }

    /*

    We can write a 2 dimential arrays or 3 d arrays. we use array literals that equal to the number of dimentions we
    want our arrays to have.
    ex. of a 2 d array: int[][] or int []... because the ... is the same as []
    a 3d array would be int or String[][][]
     */

    public static void show(int[]... my2dArray){
        // doing nested for loops to loop inside the 2 d array.
        for (int [] arr: my2dArray) {
            for (int i: arr){
                System.out.println(i);
            }
        }
    }
}
