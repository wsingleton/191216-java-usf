package com.revature;

public class StringDriver {
    public static void main(String[] args){
        String s1="North";
        String s2="North";
        String s3=new String("North");
        String s4=null;
        //value equivalence check
        System.out.println(s1==s2); // true
        System.out.println(s1==s3); // false - the references point to different objects because the new keyword creates a new object even though it's the same value
        System.out.println(s1.equals(s3)); // true - checks value, not memory location
        //s3's value is now forced into the string pool, and the object that exists outside of the string pool becomes eligible for garbage collection
        s3=s3.intern();
        //s3 is now equivalent to s1 and s2 using ==
        System.out.println(s1==s3); //true
        //concat
        s2.concat("west");
        System.out.println(s2); //still prints North
        s2=s2.concat("west");
        System.out.println(s2); //now says Northwest
        String s5="Northwest";
        //Demonstrates that the concatenated string was created outside of the string pool.  Any string API method does this.
        System.out.println(s2==s5); //false
        System.out.println(s2.equals(s5)); //true
        //Operators also create a new object outside of the string pool.
        String s6=s2+"west";
        System.out.println(s2==s6); //false
        //StringBuilder sample
        //StringBuilder sb1 = "String literals do not work!"
        StringBuilder sb2 = new StringBuilder("Hello!");
        StringBuilder sb3 = new StringBuilder("Hello!");
        //As these are both unique memory locations, these two matching values are not equivalent memory items.
        System.out.println(sb2==sb3); //false
        //Because StringBuilder items are not part of the String class, .equals is not overridden, so .equals is the same as ==
        System.out.println(sb2.equals(sb3)); //false
        //Alter a StringBuilder item - demonstrates mutability
        sb2.append(" How's it going?");
        System.out.println(sb2);
    }
}
