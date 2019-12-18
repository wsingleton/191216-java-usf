package com.revature;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayDriver<T> {
    public static void main(String[] args) {
        //create Array
        int[] intArray = new int[10];
        //output Array detail
        System.out.println("String representation of intArray: " + intArray);
        System.out.println("Length of intArray: " + intArray.length);
        //output values of intArray
        printValues(intArray);
        //set first and last values of intArray
        intArray[0]=93;
        intArray[intArray.length-1]=42;
        //output values of intArray
        printValues(intArray);
        //alternative array instantiation syntax
        double doubleVals[] = new double[5];
        //array literal sample
        String[] myStrings={"this", "is", "an", "array", new String("literal")};
        //output values of myStrings
        printValues(myStrings);
        //Array duplication
        int[] otherInts = Arrays.copyOf(intArray, intArray.length+1);
        printValues(otherInts);
        //length comparison confirmation
        System.out.println("Length of intArray: " + intArray.length);
        System.out.println("Length of otherInts: " + otherInts.length);
        //Object Array example - can include a variety of different types, will automatically "box" them
        Object[] randomStuff={12, "test", new ArrayList<Boolean>(), true, 4.3};
        //Java will also "unbox"
        int[] anotherArray={new Integer(44)};
        //intentionally throw an ArrayIndexOutOfBoundsException, line converted to comment to eliminate exception without removal
        //System.out.println(intArray[123]);
    }

    private static void printValues(int[] intArray) {
        //Traditional for loop
        for (int i=0; i<intArray.length; i++) {
            System.out.println("Value at index position " + i + ": " + intArray[i]);
        }
    }
    private static void printValues(String[] stringArray) {
        //For-each or Enhanced for loop
        for (String s : stringArray) {
            System.out.println(s);
        }
    }
}
