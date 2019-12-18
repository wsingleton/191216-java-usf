package com.revature;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayDriver {

    public static void main(String[] args) {

        int[] intArray = new int[10];
        System.out.println("String representation of intArray:" + intArray);
        System.out.println("Length of intArray:" + intArray.length);

        printValues(intArray);

        // accessing and changing values in an array
        intArray[0] = 93;
        intArray[intArray.length - 1] = 42;

        printValues(intArray);

        // an alternative syntax to instantiating arrays
        double doubleVals[] = new double[5];

        // instantiation using an array literal
        String[] myStrings = {"this","is","an","array","literal"};

        printValues(myStrings);

        //
        int[] otherInts = Arrays.copyOf(intArray, intArray.length + 1);
        printValues(otherInts);

        System.out.println("Length of intArray: " + intArray.length);
        System.out.println("Length of otherInts: " + otherInts.length);

        int[] anotherArray = {new Integer(44)}; //unboxing
        Integer[] integerArray = {123}; // autoboxing

        // Java can figure out what you meant
        System.out.println(new Integer(4) + new Integer(4));

        Object[] randomStuff = {12, "test", new ArrayList<Boolean>(), true, 4.3};

        System.out.println(intArray[123]); // throws an ArrayIndexOutOfBoundsException
    }

    private static void printValues(int[] intArray) {
        // traditional for loop
        for (int i=0; i < intArray.length; i++){
            System.out.println("Value at index position " + i + ": " + intArray[i]);
        }
    }

    private static void printValues(String[] stringArray) {
        // for-each loop (aka enhanced for loop)
        for (String s : stringArray){
            System.out.println(s);
        }
    }
}
