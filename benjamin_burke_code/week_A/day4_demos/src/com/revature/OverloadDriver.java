package com.revature;

import com.revature.util.Overloader;

public class OverloadDriver {

    public static void main(String[] args){

        Overloader overloader = new Overloader();
        overloader.method(1);         // int
        overloader.method(1L);        // long
        overloader.method();             // variable arguments
        overloader.method(1, 2, 3);  // variable arguments
       // overloader.method(null); will give you a compilation error(ambiguous type)

        overloader.method(new Integer(65));
        overloader.method(3.14);
        overloader.method(3.14f);
        overloader.method(new Double(2.9));
        overloader.method(new Float(2.9));

        //variable arguments (with unboxing!)
        overloader.method(new Integer(4), new Integer(5));
    }

}
