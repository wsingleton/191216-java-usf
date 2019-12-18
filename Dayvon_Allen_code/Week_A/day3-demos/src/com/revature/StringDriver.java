package com.revature;

//import static java.lang.System.out;

public class StringDriver {

    public static void main(String[] args){
        String s1 = "North";
        String s2 = "North";
        String s3 = new String("North");
        String s4 = null;

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);

        //strings are immutable if you don't assign the method used on a string to a variable it will not change.
        // It will also be outside of the string pool
        String newString = s2.concat("west");
        System.out.println(newString);

        //string literals do not work, you need to use the constructor
        StringBuilder sb1 = new StringBuilder("Hello World");
        StringBuilder sb2 = new StringBuilder("Hello World");
        System.out.println(sb1);
        System.out.println(sb1 == sb2);


    }
}
