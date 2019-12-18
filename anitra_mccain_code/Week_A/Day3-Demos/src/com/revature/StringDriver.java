package com.revature;


public class StringDriver {

    String s7 = new String("test");

    public static void main(String[] args) {
        String s1 = "North";
        String s2 = "North";
        String s3 = new String("North");
        //null means the lack of an object value
        String s4 = null;

        System.out.println(s1 == s2); //true
        System.out.println(s1 == s3); // equates to false because it equates whether or not the references point to the same object in heap memory.
        System.out.println(s1.equals(s3)); //true
        //== compares reference addresses (do these to objects point to the same thing in memory) .equals compares values
        /*
        * When comparing objects, == is used to check for memory location equivalence.
        * */

        /*
        * String interning is the act of moving a String object - which exists outside of the String Pool -
        * and "interning" or moving it into the String Pool.
        * */
        s3 = s3.intern(); //If object exist outside of string pool put inside string pool.
        System.out.println(s1 == s3); // now this equates to true because .intern() puts object in string pool

        //----------------------------------------------------------------------------------------------------

        /*
        Strings are immutable
        * StringBuilder
        *   -mutable
        *   -not thread-safe
        * StringBuffer
        *   -mutable
        *   -thread-safe
        * */
        //     StringBuilder sb1 = "does not work";
        StringBuilder sb2 = new StringBuilder("Hello!");
        StringBuilder sb3 = new StringBuilder("Hello!");

        System.out.println("----------------------");

        /*
        * The StringBuilder/Buffer classes do not override the implementation of the .equals() method - keeping the
        * original implementation provided by the Object class, which is the exact same as ==
        * */
        System.out.println(sb2 == sb3);
        System.out.println(sb2.equals(sb3)); // false
    }
}
