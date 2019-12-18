package com.revature;

import static java.lang.System.out;

public class StringDriver {

    String s7 = new String("test");

    public static void main(String[] args) {

        String s1 = "North";
        String s2 = "North";
        String s3 = new String("North");
        String s4 = null;

        /*
            When comparing objects, == is used to check for memory location equivalence.

            To C
         */

        out.println(s1 == s2); // true
        out.println(s1 == s3); // false
        out.println(s1.equals(s3)); // true 'use this method to check compare values of an object'

        /*
            String interning is the act of moving a String object - which
            exists outside of the String Pool - and "interning" or moving
            it into the String Pool
         */

        s3 = s3.intern();
        out.println(s1 == s3); // true after the change bc it points to the same object now

        /*

         */

        s2.concat("west");
        out.println(s2);

        s2 = s2.concat("west"); // "Northwest" was created outside of the String Pool
        out.println(s2);

        String s5 = "Northwest";
        out.println(s2 == s5); // false (bc "Northwest" was created in the string pool when s5 was created)
        out.println(s2.equals(s5));

        String s6 = s2 + "west";
        out.println(s2 == s6);

        //---------------------------------------------------------------------------------------

        /*
            StringBuilder
                - mutable
                - not thread-safe

            StringBuffer
                - mutable
                - thread-safe
         */

//        StringBuilder sb1 = "Does not work";
        StringBuilder sb2 = new StringBuilder("Hello!");
        StringBuilder sb3 = new StringBuilder("Hello!");

        /*
            The StringBuilder/Buffer classes do not override the implementation
            of the .equals() method - keeping the original implemnetation provided
            by the Object class, which is the exact same as ==
         */
        out.println(sb2 == sb3); // false
        out.println(sb2.equals(sb3)); // false

    }
}
