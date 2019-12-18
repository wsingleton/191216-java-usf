package com.revature;

import java.util.Arrays;

public class ArrayDriver {
    public static void main(String[] args) {
        int[] intArray = new int [10]; //the length of the array will be 10, index will go to 9
        //intArray. //can use dot operator "." to show that its an object
        System.out.println("String representation of intArray: "+ intArray);
        System.out.println("Length of intArray: " + intArray.length);

        printValues(intArray);//highlight ->right click-> refactor -> extract method
        intArray[0] = 93;
        intArray[intArray.length - 1] = 42; //changing value of the last number in an array

        printValues(intArray);

        double doubleVals[] = new double[5]; //another way to instantiation dont like this way

        String[] myStrings = {"this", "is", "an", "array", new String("literal")}; //all are string literals


        int[] otherInts = Arrays.copyOf(intArray, intArray.length + 1);
        System.out.println("Length of intArrays: " + intArray.length);
        System.out.println("Length of otherInts: " + otherInts.length);

        int[] anotherArray = { new Integer(44)};



        System.out.println(intArray[123]);//throws expection
    }

    private static void printValues(int[] intArray) {
        //traditional for loop
        for (int i = 0; i < intArray.length; i++){
            System.out.println("Value at index position " + i + ": " + intArray[i]);
        }
    }
    private static void printValues(String[] stringArray){
        //for - each loop (aka enhanced for loop)
        for (String s : stringArray){
            System.out.println(s);
        }
    }
}

