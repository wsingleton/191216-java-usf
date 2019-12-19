package com.revature.util;
import com.revature.util.Overloader

public class OverloadDriver {

    public static void main(String[] args){

        Overloader overloader = new Overloader();
        overloader.method(1); // int
        overloader.method(1L); //long
        overloader.method(); //varargs
        overloader.method(1,2,3); //varargs
       // overloader.method(null);//compile error
        overloader.method(new Integer(65)); //Integer
        overloader.method(3.14); //double
        overloader.method(3.14f); //float
        overloader.method(new Double(2.9)); //double
        overloader.method(new Float(2.9)); //float

        //variable args (with unboxing!)
        overloader.method(new Integer(4), new Integer(5));


    }

}
