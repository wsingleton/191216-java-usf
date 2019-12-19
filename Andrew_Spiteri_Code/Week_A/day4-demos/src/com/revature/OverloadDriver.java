package com.revature;

import com.revature.util.Overloader;

public class OverloadDriver {
    public static void main(String[] args) {
        Overloader overloader = new Overloader();

        overloader.method(1);       //int
        overloader.method(1L);      //long
        overloader.method();        //variable args
        overloader.method(1, 2, 3); //variable args
//      overloader.method(null);        //compilation error
        overloader.method(new Integer(65)); //Integer Wrapper
        overloader.method(3.14);    //double
        overloader.method(3.14f);   //float
        overloader.method(new Double(3.14)); // Double Wrapper
        overloader.method(new Float(3.14));  //Float Wrapper

        //variable arguments (with unboxing!)
        overloader.method(new Integer(4), new Integer(5));
    }
}
