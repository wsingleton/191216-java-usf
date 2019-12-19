package com.revature;
import com.revature.util.Overloader;

public class overloadDriver{
 public static void main(String[]arg){
Overloader overloader =new Overloader();
overloader.method(1); //int
overloader.method(1); //long
overloader.method(); //variable arguments
overloader.method(1,2,3);  //variable arguments
//overloader.method(null);//compilation error
     overloader.method(new Integer(65));//Integer
     overloader.method(3.14);   //double
     overloader.method(3.14f);//float
     overloader.method(new Double(2.9));//Double

     //variable arguments(with unboxing!)
     overloader.method(new Integer(4), new Integer(5));




    }

    }

