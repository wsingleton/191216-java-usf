package com.revature;

public class VarArgsDriver {

    /*
    the main method can use variable args and still be considered valid syntactically
     */

    public static void main(String[] args){
    varArgs("test");
    varArgs("test",1);
    varArgs("test",1,2,3);

    System.out.println("--------- check -----check ------check-------");
    // 2 d array
        int[][] twoDimArr={
                {1,2,3},
                {4,5,6},
                {6,7,8}
        };

    show(twoDimArr);

    }


    // Variable args must be the las parameter

    public static void varArgs(String myString, int... values){
        System.out.println(myString);
        for (int i : values){
            System.out.println(i);
        }
    }

    /*
        we can make our variable args as many dimentional as desinged, just add a set of square bracket and the ellipse
        to pass in multil dimentional array
     */
    public static void show(int[]... myArray){

        for (int i = 0 ; i < myArray.length;i++){
            for(int j = 0; j <myArray[i].length; j++ ){
                System.out.println(myArray[i][j]);
            }
        }

        System.out.println("----------------------sssss------------------");

        for (int[] arr: myArray ) {
            for (int i: arr) {
                System.out.println(i);

            }

        }

    }
}
