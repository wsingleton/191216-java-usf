package com.revature;


public class StingDriver {

    public static void main(String[] args) {

        String s1 = "North";
        String s2 = "North";
        String s3 = new String("North");
        String s4 = null;

        System.out.println(s1 == s2); // true
        System.out.println(s1 == s3); //false
        System.out.println(s1.equals(s3)); //true


        s2.concat("west");
        System.out.println(s2);

        s2 = s2.concast("west");
        System.out.println(s2);

        String s5 = "Northwest";
        System.out.println(s2 == s5);

        s3 = s3.intern();
        System.out
    }
}
