package com.revature;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayDriver {
    public static void main(String[] args){

        int[] intArray = new int[10];
        System.out.println("String representation of intarray: " + intArray);
        System.out.println("Length of array: " + intArray.length);

        printValues(intArray);

        intArray[0] = 93;
        intArray[intArray.length - 1] = 42;
        Object[] randomStuff = {1, "Hello", 4.3, true, new ArrayList<Boolean>()};
        printValues(intArray);

        //alternative syntax to instantiating arrays
//        double doubleVal[] = new double[5];

        //instantiation using an array literal
        String[] myStrings = {"Blah", "Blah", "Blah"};
        printValues(myStrings);

        int[] otherInts = Arrays.copyOf(intArray, intArray.length + 1);
        System.out.println("Length of intArray: " + intArray.length);
        System.out.println("Length of otherInts: " + otherInts.length);
        System.out.println("-----------------------END-------------------------------");
        printValues(otherInts);
    }

    private static void printValues(int[] intArray) {
        for(int i = 0; i < intArray.length; i++){
            System.out.println("Value at index position " + i + ": " + intArray[i]);
        }
        System.out.println("-----------------------END-------------------------------");
    }

    private static void printValues(String[] stringArray) {
        for(String s: stringArray){
            System.out.println(s);
        }
        System.out.println("-----------------------END-------------------------------");
    }
}
