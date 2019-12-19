package com.revature;
import com.revature.util.Overloader;

public class OverloadDriver {

    public static void main(String[] args){

        Overloader overloader = new Overloader();
        overloader.method(1);   //int
        overloader.method(1L);  //long
        overloader.method();       // variable arguments
        overloader.method(1, 2, 3); //variable arguments
        // compilation error
        //overloader.method(null); error ambiguity. null is the absence of an object.
        overloader.method(new Integer(65)); // integer
        overloader.method(3.14); //call double by default b/c float is not as precise
        overloader.method(3.14f); // float
        overloader.method(new Double(2.99)); // double
        overloader.method(new Float(2.9)); // float

        //variable arguments (with unboxing!)
        overloader.method(new Integer(4), new Integer(5));
    }
}
