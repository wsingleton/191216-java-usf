package com.revature;

public class VarArgsDriver {
    //The main method may use variable arguments and still be considered valid syntactically.
    public static void main(String... args) {
        //sample functionality of variable arguments in action
        varArgs("test");
        varArgs("test2", 1);
        varArgs("test3",1,2,3);
        //instantiating a 2-d array using array literals
        int[][] twoDimArr = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        //calling the showVals method
        showVals(twoDimArr);
        String[][] associates191216 = {
                {"Wezley","Singleton"},
                {"Tannilen","Reagan"},
                {"Alexis","Lindsay"},
                {"Andrew","Spiteri"},
                {"Anitra","McCain"},
                {"Anthony","Smith"},
                {"Benjamin","Burke"},
                {"Blake","Dunn"},
                {"Dayvon","Allen"},
                {"Ervin","Stewart"},
                {"Evan","Hsi"}
        };
        showVals(associates191216);
    }
    /*  Variable arguments must be the last parameter in the parameters list.
        There can only be one variable argument parameter in a method.*/
    public static void varArgs(String myString, int... values) {
        System.out.println(myString);
        for (int i : values) {
            System.out.println(i);
        }
    }
    /* Functionality of multidimensional arrays in for-loops */
    public static void showVals(int[]... my2dArray){
        for(int[] arr: my2dArray) {
            for (int i : arr) {
                System.out.println(i);
            }
        }
    }
    public static void showVals(String[]... my2dArray){
        for(String[] arr: my2dArray) {
            for (String i : arr) {
                System.out.println(i);
            }
        }
    }
}
