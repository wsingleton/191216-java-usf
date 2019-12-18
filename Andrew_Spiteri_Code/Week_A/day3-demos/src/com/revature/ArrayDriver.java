package com.revature;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayDriver <T> {

    public static void main (String[] args){
        int[] intArray = new int [10];
        System.out.println("String representation of intArray: "+intArray);
        System.out.println("Length of the intArray: "+intArray.length + "\n");

        printValues(intArray);

        intArray[0] = 93;
        intArray[intArray.length-1] = 42;

        printValues(intArray);

        double doubleVals[] = new double[5];
        String[] myString = {"string", "array", "literal", new String("literal")};
        float[] myFloat = {8.8f, 7.5f};

        int[] otherInts = Arrays.copyOf(intArray, intArray.length+1);

        printValues(otherInts);
        System.out.println("Length of intArray " + intArray.length);
        System.out.println("Length of otherInts " + otherInts.length);

        Object[] randomStuff = {12, "string", new ArrayList<Boolean>(), true, 4.3};

        System.out.println(new Integer(44) + 12);
    }

    private static void printValues(int[] intArray) {
        for(int i = 0; i < intArray.length; i++){
            System.out.println("Value at index position " + i + ": " + intArray[i]);
        }
        System.out.println();
    }

    private static void printValues(String[] stringArray) {
        for(String s: stringArray){
            System.out.println(s);
        }
        System.out.println();
    }
}
