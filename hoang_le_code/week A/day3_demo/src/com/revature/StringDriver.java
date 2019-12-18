package com.revature;

public class StringDriver {
    public static void main(String[] args){
        String s1 = "north";
        String s2 = "north";
        String s3 = new String("north");
        String s4 = null;
        /*
        when comparing object, == is
         */
        System.out.println(s1==s2);//true
        System.out.println(s1==s3);
        System.out.println(s1.equals(s2));
        // it will de refrence this object and put this object into string pool
        // if it already exist then just point to it

        s3 = s3.intern();
        System.out.println(s1==s3);

        /*
            String are immuable
            String created by using String literal are made within String pool
            String created by using Sring  api method is create out side the String pool
            String object which are out site the String pool can be added in to the poll by using intern method

         */
        s2.concat("west");
        System.out.println(s2);
        s2 = s2.concat("west");
        System.out.println(s2);
        String s5 = "northwest";
        System.out.println(s2==s5);
        System.out.println(s2.equals(s5));

        /*
        Stringbuider
            mulable
            not thread safe
        Stringbuffer
            mulable
            thread safe



         */

        // StringBuilder sb1 = "does not work "
        StringBuilder sb1 = new StringBuilder("hello");
        StringBuilder sb2 = new StringBuilder("hello");
        System.out.println(sb1==sb2);
        System.out.println(sb2.equals(sb1));
        // false because the Stringbuilder classes donot overide the impelementation
        //of the .equal() method. keeping the original implementation provide by
        // the object class is exact double equal (==) 
    }
}
