package com.revature;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayDriver {

    public static void main(String[] args) {

        int[] intArray = new int[10];
        System.out.println("String representation of intArray: " + intArray);
        System.out.println("Length of intArray: " + intArray.length);

        printValues(intArray);
        //accessing and changing
        intArray[0] = 93;
        intArray[intArray.length - 1] = 42;

        printValues(intArray);

        //an alternative syntax to instantiating arrays
        double doubleVals[] = new double[5];

        //instantiation using an array literal
        // String[] myStrings = {"this", "is", "an", "array", "literal"};

        String[] myStrings = {"this", "is", "an", "array", new String("literal")};
        printValues(myStrings);


        int[] otherInts = Arrays.copyOf(intArray, intArray.length + 1);
        printValues(otherInts);

        System.out.println("Lenght of the intArrays: " + intArray.length);
        System.out.println("Lenght of otherInts: " + otherInts.length);

        int[] anotherArray = { new Integer(44)}; // unboxing
        Integer[] integerArray = { 123 }; //autoboxing

        Object[] randomStuff = { 12, "text", new ArrayList<Boolean>(), true, 4.3};

        System.out.println(intArray[123]); //throws an ArrayIndexOutOfBoundsException
    }

    private static void printValues(int[] intArray) {
        for (int i = 0; i < intArray.length; i++) {
            System.out.println("value at index position" + i + ": " + intArray[i]);
        }
    }


    private static void printValues(String[] stringArray) {
        for (String s : stringArray) {     //for-each loop (aka enhanced for loop)
            System.out.println(s);
        }
    }
}