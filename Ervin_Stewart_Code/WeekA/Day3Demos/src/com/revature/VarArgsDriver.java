package com.revature;import com.revature.ArrayDriver;

public class VarArgsDriver {

    //public static myobject{

   // }

    /*the main method can use variable arguments and still be considered valid syntactically*/
    public static void main(String... args){
        int[] numArr = {1,2,3};
       ArrayDriver.printValues(numArr);
        varArgs("test");
        varArgs("test2");
        varArgs("test3", 1,2,3);
        int[][] twoDimArr = {{1,2,3},{4,5,6},{7,8,9}};
        show(twoDimArr);

    }



    /* Variables arguments MUST be the last parameter in the parameter list*/

    public static void varArgs(String myString, int... values){
        System.out.println(myString);
        for(int i: values){
            System.out.println(i);
        }


    }
    /*We can make our variable arguments as many dimensions as desired,
    just add a set of square brackets and the ellipses to pass in a
    multi-dimensional array.*/

    public static void show(int[]... my2dArray){

        for (int i =0; i< my2dArray.length; i++){
            for(int j = 0; j<my2dArray.length;j++){
                System.out.println(my2dArray[i][j]);

            }

        }


        for (int[] arr : my2dArray){
            for(int i : arr) {
                System.out.println(i);
            }
        }

    }
}
