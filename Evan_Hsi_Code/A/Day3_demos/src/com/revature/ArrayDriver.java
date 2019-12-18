package com.revature;

import java.util.Arrays;

public class ArrayDriver {

    public static void main(String[] args) {

        int[] intArray = new int[10];
        System.out.println("String representation of intArray: " + intArray);
        System.out.println("length of intArray: " + intArray.length);

        for(int i = 0; i < intArray.length; i++) {
            System.out.print(intArray[i] + " ");
        }
        System.out.print("\n");

        int[] otherInts = Arrays.copyOf(intArray, intArray.length + 1);

    }

}
