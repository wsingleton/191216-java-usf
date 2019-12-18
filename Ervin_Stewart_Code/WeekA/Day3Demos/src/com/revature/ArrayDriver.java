package com.revature;
import java.util.Arrays;
import java.util.ArrayList;

public class ArrayDriver<T> {

    public static void main(String[] args){
        String NameArray[][];
        int[] intArray = new int[10];
        System.out.println("String representation of intArray " + intArray);
        System.out.println("Length of intArray " + intArray.length);
       //NameArray= ;

        intArray[0] = 93;
        intArray[intArray.length - 1] = 42;
        printValues(intArray);


        double doubleVals[] = new double[5];

        String[] myString = {"this","is","an","array",new String("literal")};


        printValues(myString);
        int[] otherInts = Arrays.copyOf(intArray, intArray.length +1);
        printValues(otherInts);

        System.out.println("Length of intArray " + intArray.length);

        System.out.println("Length of otherInts " + otherInts.length);
        int[] anotherArray = {new Integer(44)};//unboxing
        Integer[] integerArray = {123};//autoboxing

        //java can figure out what you meant
        System.out.println(new Integer(4)+ new Integer(4));

        Object[] randomStuff = {12, "test", new ArrayList<Boolean>(), true, 4.3};
    }

    public static void printValues(int[] intArray) {
        for(int i =0; i<intArray.length; i++){
            //traditional for loop
            System.out.println("Value at index position " + i + ": " + intArray[i]);
        }
    }
    private static void printValues(String[] intArray) {
        //for-each loop for iterating a whole loop instead of indexing
        for(String s : intArray){
            System.out.println(s);
        }
    }

}
