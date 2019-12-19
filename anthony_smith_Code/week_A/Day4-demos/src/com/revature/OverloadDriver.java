package com.revature;

        import com.revature.util.Overloader;

public class OverloadDriver {

    public static void main(String[] args){

        Overloader overloader = new Overloader();
        overloader.method(1);                    //int
        overloader.method(1L);                   //Long
        overloader.method();                       //varArgs
        overloader.method(1,2,3);               //varArgs
     // overloader.method(null);                   //compilations err
        overloader.method(new Integer(11));  //Integer
        overloader.method(3.4);                 //double by default
        overloader.method(3.4F);                //float
        overloader.method(new Double(2.9));
        overloader.method(new Float(2.9));




    }
}
