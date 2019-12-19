package com.revature;

import com.revature.Util.OverLoader;

public class OverLoadDriver {
    public static void main(String args[]){
        OverLoader overloader = new OverLoader();
        overloader.method(1);   //int
        overloader.method(1l);  //long
        overloader.method();    //variable argusment
        overloader.method(1,2,3); // variable argusment
      //  overloader.method(null); will through an compilation error ambiguous type
        overloader.method(new Integer(2)); // Interger
        overloader.method(3.14); // primitive double
        overloader.method(3.14f);// Primitive type float value
        overloader.method(new Double(22.1));
        overloader.method(new Float(22.1));

        //variable arguments with unboxing 
        overloader.method(new Integer(4), new Integer(5));

    }
}
