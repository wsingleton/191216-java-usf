package com.revature;
import static java.lang.System.out;

public class StringDriver {

    public static void main(String... args){
        String s1 = "North";
        String s2 = "North";
        String s3 = new String("North");
        String s4 = null;


        out.println(s1 == s2);//true
        out.println(s1 == s3);// false, S3 is an object that but contains the same value as s2
        out.println(s1.equals(s3));

        /*
        String interning is the act of moving a string object - which
        exists outside of the String pool - and "interning" or moving
         it into the String pool.
         */

        s3 = s3.intern();
        out.println(s1 == s3);// true because it now points to the same object
        /*
        -Strings are immutable

        -Strings created using the string literals are made w/in the String pool

        -Strings created using the string constructor, String API methods, or by
        concatenation are always created outside of the string pool
        */

        s2.concat("West");
        out.println(s2);

        s2 = s2.concat("West");
        out.println(s2);

        String s5 = "NorthWest";
        out.println(s2 == s5);

/*
        String Builder
            -mutable
            -not thread-safe

        thread safe = not affecting other threads multiple processes may overlap

        String Buffer
            -mutable
            -thread-safe
 */
        //StringBuilder sb1 = "does not work";
        StringBuilder sb2 = new StringBuilder("Hello!");
        StringBuilder sb3 = new StringBuilder("Hello!");
        /*
        The StringBuilder/Buffer classes do not override the implementation of the .equals() method
        - keeping the original implementation provided by the Object class, which is the exact same as ==
         */

        out.println(sb2 == sb3);//false
        out.println(sb2.equals(sb3));

    }
}
