package com.revature;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.Arrays;
public class ArrayDriver<T> {
    public static void main(String[] args) {
        int[] intArray = new int[10];
        System.out.println("String representation of the array" + intArray);
        System.out.println("Print length of the array" + intArray.length);
        printValue(intArray);
        //accessing and changing values of an array
        intArray[0] = 93;
        intArray[intArray.length-1] = 42;
        printValue(intArray);

        double doubleVals[] = new double[5]; // alternative syntax to instantiating an array

        String s = "test";

        String[] myString = { "This ","is ","an ", "array ", new String("literal")}; //instantiation using a literal

        int[] otherInts = Arrays.copyOf(intArray, intArray.length+1);
        printValue(otherInts);

        System.out.println("Length of intArray: " + intArray.length);
        System.out.println("Length of otherInts: " + otherInts.length);

        int[] anotherArray = { new Integer(44)}; // unboxing
        Integer[] integerArray = { 123 }; //autoboxing

        Object[] randomStuff = {12, "test", new ArrayList<Boolean>(), true, 4.3};

    }

    private static void printValue(int[] intArray) {
        for(int i=0 ; i < intArray.length ; i++) {
            System.out.println("The value of the index " + i + "in the Array is " + intArray[i] );
        }
    }

    private static void printValue(String[] stringArray) {
        //for-each loop (enhanced for loop)
        for(String s : stringArray) {
            System.out.println(s);
        }
    }
}
