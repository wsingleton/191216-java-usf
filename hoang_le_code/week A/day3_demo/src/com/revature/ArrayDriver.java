package com.revature;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayDriver {
    public static void main(String args[]){
        int[] intArray = new int[10];
        System.out.println("string representation of a array " + intArray);
        System.out.println("length of array "+ intArray.length);
        printValue(intArray);
        intArray[0]= 93;
        intArray[intArray.length-1]= 42;
        printValue(intArray);

        //an alternative syntax to instanliating array
        double[] doubleVale = new double[5];
        // instantiation using an array litera
        String[] myString = {"this", "is","an", "array", new String("literral")};
        printValueString(myString);

        int[] otherInt= Arrays.copyOf(intArray,intArray.length + 1);

        printValue(otherInt);

        System.out.println("length of int array " + intArray.length);
        System.out.println("length of other Array "+ otherInt.length);

        Object[] randomStuff = {12,"test", new ArrayList<Boolean>(), true, 4.3};

        int[] anotherArray = {new Integer(14)};
        Integer[] integersArray = {123};



    }

    private static void printValue(int[] intArray) {
        //traditional for loop
        for(int i = 0 ; i < intArray.length; i++){
            System.out.println("value of index " + i + " in the array is: " + intArray[i] );
        }
    }

    private static void printValueString(String[] Array) {
        //for each loop (aka enhanced for loop)
       for (String s : Array){
           System.out.println(s);
       }
    }
}
