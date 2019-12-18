package com.revature;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayDriver {

    public static void main(String[] args) {

        int[] intArray = new int[10];
        System.out.println("String representation of intArray: " + intArray);
        System.out.println("Length of intArray " + intArray.length);

        printValues(intArray);

        intArray[0] = 93;
        intArray[intArray.length - 1] = 42;

        printValues(intArray);

        double doubleVals[] = new double[5];
        String s = "test";

        String[] myStrings = { "this", "is", "an", "array", new String("literal"), s };

        printValues(myStrings);

        int[] otherInts = Arrays.copyOf(intArray, intArray.length + 1);
        printValues(otherInts);

        System.out.println("Length of intArray: " + intArray.length);
        System.out.println("Length of otherInts: " + otherInts.length);

        Object[] randomStuff = { 12, "test", new ArrayList<Boolean>(), true, 4.3};

      }

    private static void printValues(int[] intArray) {
        for (int i = 0; i < intArray.length; i++) {
            System.out.println("Value at index position " + i + ": " + intArray[i]);
        }
    }
        private static void printValues(String[] stringArray) {
            for (String s : stringArray){
                System.out.println(s);
            }

        }
    }
