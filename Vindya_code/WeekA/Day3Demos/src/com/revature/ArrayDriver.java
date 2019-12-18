package com.revature;

public class ArrayDriver {
    public static void main(String[]args){
        int[]intArray=new int[10];
        System.out.println("String representation of intArray:"+intArray);
        System.out.println("Length of intArray: "+ intArray.length);
        printValues(intArray);

        intArray[0] =93;
        intArray[intArray.length -1]=42;

        printValues(intArray);

        double doubleVals[] = new double[5];
        String s ="test";
        String myArray[] = {"this", "is", "an","array",new String("literal")};
        System.out.println(intArray[123]);
    }

    private static void printValues(int[] values) {
        for (int i = 0; i < values.length; i++) {
            System.out.println("value at index position" + i + ":" + values[i]);
        }
    }


    private static void printValues(String[] values) {
        for(String s : values) {
            System.out.println(s);
        }
    }
}
