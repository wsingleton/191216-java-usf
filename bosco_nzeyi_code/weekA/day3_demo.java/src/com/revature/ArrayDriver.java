package com.revature;

import java.util.Arrays;

public class ArrayDriver {
    public static void main (String[] args){
        int[] intArray = new int[10];
        System.out.println("String representation is " + intArray);
        System.out.println("The length of this Array is " + intArray.length);

        printValues(intArray);
        intArray[0] = 20;
        intArray[intArray.length - 1] = 50;
        printValues(intArray);

        int[] otherInts = Arrays.copyOf(intArray, intArray.length + 1);
        int[] anotherArray = {new Integer(4)};
        Integer someInts = 100;
        System.out.println("The length of this otherInts " + otherInts.length);

        // instantiating a string using string literals
        String[] stringArray = {"letA", "letB", "else", new String("literal")};

        for (String string : stringArray
             ) {
            System.out.println(string);
        }

    }

    private static void printValues(int[] intArray) {
        for(int i = 0; i<intArray.length; i++){
            System.out.println("The int at position "+ i + " is " + intArray[i]);
        }
    }
}
