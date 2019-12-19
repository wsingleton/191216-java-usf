package com.revature;

import com.revature.util.Overloader;

public class OverloadDriver {
    public static void main(String[] args){
        Overloader overloader=new Overloader();
        overloader.method(1);                               //primitive type int value
        overloader.method(1L);                              //primitive type long
        overloader.method();                                //variable arguments
        overloader.method(1,2,3);                           //variable arguments
//      overloader.method(null);                            //compilation error (ambiguous type)
        overloader.method(new Integer(5));                  //explicit type Integer
        overloader.method(3.14);                            //primitive type double by default
        overloader.method(3.14F);                           //primitive type float by explicit casting
        overloader.method(new Integer(4),new Integer(5));   //variable arguments, will unbox automatically
    }
}
