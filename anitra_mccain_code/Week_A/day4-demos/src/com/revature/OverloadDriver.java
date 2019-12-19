package com.revature;

import com.revature.util.Overloader;

public class OverloadDriver {

    public static void main(String[] args) {

        Overloader overloader = new Overloader();

        //run in console to view answers
        overloader.method(1);
        overloader.method(new Integer(65));
        overloader.method(1L);
        overloader.method();
        overloader.method(1,2,3);
        //    overloader.method(null); // compilation error (ambiguous type)
        overloader.method(3.14);
        overloader.method(3.14F);

        overloader.method(new Double(2.9));
        overloader.method(new Float(2.9));

        //variable arguments (with unboxing)
        overloader.method(new Integer(4), new Integer(5));
    }

}
