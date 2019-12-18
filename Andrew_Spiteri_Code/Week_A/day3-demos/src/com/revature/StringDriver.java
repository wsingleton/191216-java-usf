package com.revature;

public class StringDriver {
    public static void main(String[] args){
        String s1 = "North";
        String s2 = "North";
        String s3 = new String("North");
        String s4 = null;

        /*
            When comparing objects, == is used to check for memory location equivalence.
            To
         */
        //picture of String pool
        System.out.println(s1 == s2); //true
        System.out.println(s1 == s3); //false
        System.out.println(s1.equals(s3)); //true

        //String interning is the act of moving a String object - which
        //exists outside of the String Pool - and "interning" or moving
        //it into the String Pool
        s3 = s3.intern(); //puts String in String pool
        System.out.println(s1 == s3); //true

        /*

         */
        s2 = s2.concat("west");
        System.out.println(s2);

        /*
            String methods create the String outside of the String pool
         */
        String s5 = "Northwest";
        System.out.println(s2 == s5); //false
        System.out.println(s2.equals(s5)); //true

        String s6 = s1 + "west";
        String s7 = "Northwest";
        System.out.println(s7 == s6); //false

        /*
            StringBuilder
                mutable
                not thread-safe
            StringBuffer
                mutable
                thread-safe
            String
                thread-safe because it is immutable
         */

        //StringBuilder sb1 = "Does not work"
        StringBuilder sb2 = new StringBuilder("Hello!");
        StringBuilder sb3 = new StringBuilder("Hello!");

        /*
            The StringBuilder/Buffer classes do not override the implementation of the .equals()
            method - keeping the original implementation provided
            by the Object class, which is
         */
        System.out.println(sb2 == sb3); //false
        System.out.println(sb2.equals(sb3)); //false (b/c

        sb2.append(" How's it going?");
        System.out.println(sb2);

    }
}
