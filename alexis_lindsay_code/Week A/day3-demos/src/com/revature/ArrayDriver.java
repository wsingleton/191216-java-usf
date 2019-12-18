package com.revature;

public class ArrayDriver {
    public static void main (String[] args) {
        int[] intArray = new int[10];
        System.out.println("String Representation of  intArray" + intArray);
        System.out.println("length of intArray" + intArray.length);


        printValues(intArray);

        intArray[0] = 93;
        intArray[intArray.length - 1] =42;
        double[] doublevals = new double[5];
        String[] stringArray = {"butter", "peanut butter", "almond butter", "applebutter"};

        for (String s: stringArray) {
            System.out.println(s);
        }

        printValues(intArray);
    }

    private static void printValues(int[] intArray) {
        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }



}
