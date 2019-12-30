package com.revature;

import java.util.Arrays;

public class ArrayDriver {

    public static void main(String[] args) {

        int[] intArray = new int[10];
        System.out.println("String representation of intArray: " + intArray);
        System.out.println("length of intArray:" + intArray.length);

        printValues(intArray);

        intArray[0] = 93;
        intArray[intArray.length -1 ] = 42;

        printValues(intArray);

        // an alternative syntax to instantiating arrays
        double doubleVals[] = new double[5];

        String s ="test";

        // instantiation using an array literal
        String[] myString = {"this", "is", "an", "array", new String("literal"), s };

        printValues(myString);

        System.out.println(intArray[123]); //throws an ArrayIndexOutOfBoundsException

        int[] otherInts = Arrays.copyOf(intArray, intArray.length + 1);
     }

    private static void printValues(int[] intArray) {
        for (int i = 0; i < intArray.length; i++) {
            System.out.println("Value at index position" + i + ": "  + intArray[i]);
        }
     }

     private static void printValues(String[] stringArray) {
        // for-each loop )aka enhanced for loop)
         for (String s : stringArray) {
             System.out.println(s);
         }
     }
}
