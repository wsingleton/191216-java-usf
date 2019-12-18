package com.revature;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayDriver<T> {

    public static void main(String[] args) {
        int[] intArray = new int[10];
        System.out.println("Here is the array: " + intArray);
        System.out.println("Length of intArray: " + intArray.length);

        printvalues(intArray);


        intArray[0] = 93;
        intArray[intArray.length-1] = 42;

        printvalues(intArray);

        // an instantiation using an array literal
        double doublevals[] = new double[5]; //legal way to do it

        String[] myStrings = {"this", "is ", "an", "array", "literal", new String("literal")};
        String s="test";

        printvalues(myStrings);


        int[] otherInts = Arrays.copyOf(intArray, intArray.length+1);
        printvalues(otherInts);

        System.out.println("length of intArray: " + intArray.length);
        System.out.println("lenght of otherInt: " + otherInts.length);

        int[] anotherArray = { new Integer(44)};
        Integer[] integerArray = { 123 };

        //java can know what you mean
        System.out.println(new Integer(4) + new Integer(4));

        Object[] randomStuff = { 12, "test", new ArrayList<Boolean>(), true, 4.3};

        System.out.println(intArray[123]);//throws an exception
    }

    private static void printvalues(int[] intArray) {
        for (int i =0; i<intArray.length; i++){
            System.out.println("value at index position: " + i + ": " + intArray[i]);
        }
    }
    //for-each loop (aka enhanced for loop)
    private static void printvalues(String[] stringArray) {
        for (String s : stringArray){
            System.out.println(s);
        }
    }

}
