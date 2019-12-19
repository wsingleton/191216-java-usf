package com.revature;

import com.revature.util.Overloader;

public class OverloadDriver {

    // Provide comments/ sudo-code :(/documenting the method
    // make sure you use descriptive (as descriptive as possible) names with classes, methods, and variables!!
    // use method overloading when you have the same task with the same name but different parameters

    public static void main(String[] args) {

        Overloader overloader = new Overloader();
        overloader.method(1); // int
        overloader.method(1L); // long
        overloader.method(); // var args
        overloader.method(1,2,3); // var args
        //overloader.method(null); //passing null will be treated as and object and will cause compilation error (ambiguous type)
        overloader.method(new Integer(38)); // Integer
        overloader.method(3.14); //usually defaults to less memory but this is the exception, will be double
        overloader.method(3.14f); // float
        overloader.method(new Double(2.99)); // double
        overloader.method(new Float(2.9)); // float
        // var args w/ unboxing
        overloader.method(new Integer(4), new Integer(5));

    }


}
