package com.revature;

public class ArrayDriver {

    public static void main(String[] args) {
        int[] intArray = new int[10];
        System.out.println("Here is the array: " + intArray);
        System.out.println("Length of intArray: " + intArray.length);

        printvalues(intArray);


        intArray[0] = 93;
        intArray[intArray.length-1] = 42;

        printvalues(intArray);

        System.out.println(intArray[123]);//throws an exception


    }

    private static void printvalues(int[] intArray) {
        for (int i =0; i<intArray.length; i++){
            System.out.println("value at index position: " + i + ": " + intArray[i]);
        }
    }
}
