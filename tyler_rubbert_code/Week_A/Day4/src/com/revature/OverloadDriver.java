package com.revature;

import com.revature.util.Overloader;

public class OverloadDriver {

    public static void main(String[] args) {

        Overloader overloader = new Overloader();
        overloader.method(1);                  // int
        overloader.method(1L);                 // long
        overloader.method();                      // variable arguments
        overloader.method(1, 2, 3);           // variable arguments
 //     overloader.method(null);                  // compilation error (ambiguous type)
        overloader.method(new Integer(65)); // Integer
        overloader.method(3.14);               // double
        overloader.method(3.14f);              // float
        overloader.method(new Double(2.9)); // Double
        overloader.method(new Float(2.9));  // Float

        // variable arguments (with unboxing!)
        overloader.method(new Integer(4), new Integer(5));

    }

}
