package com.revature;

import java.util.Arrays;

import static java.util.Arrays.*;

public class ArrayDriver {

    public static void main(String[] args){

        int[] intArray =  new int[10];
        System.out.println("String representation of intArray: " + intArray);
        System.out.println("length of array " + intArray.length);

        printValues(intArray);

        intArray[0] = 99;
        intArray[intArray.length-1] = 42;

        printValues(intArray);

        // System.out.println(intArray[123]);

        int[] otherInts = copyOf(intArray,  intArray.length + 1);

        System.out.println("Length of intArray: " + intArray.length);
        System.out.println("Length of otherInts: " + otherInts.length);

        int[] anthoerArray = {new Integer(44)}; // unboxing
        Integer[] integerArray = {123}; // autoboxing



    }

    private static void printValues(int[] intArray) {
    for(int i = 0; i < intArray.length; i++){
        System.out.println("value at index position " + i + ":" + intArray[i]);
         }
    }

    private static void printValues(String[] stringArray) {
        //for-each loop (aka enhanced for loop)
        for (String s :stringArray){
            System.out.println(s);
        }
    }


}
