package com.revature.util;

import com.revature.models.Alpha;
import com.revature.models.Circle;

public class Charlie extends Alpha {
//    @Override
//    String packageStringGetter() {
//        return "a";
//    }

    //protected member are visible to all subclasses, even if they
    // are located in a different package
    @Override
    protected double protectedDoubleGetter() {
        return 3.14;

    }
    //you cannpt override a method by replacing the return type with a completely different type
//    @Override
//    public String getCircle(){
//        return "";
// we cannot make the return type of the method a parent class of the inherited method
//    @Override
//    public Shape getCircle(){
//        return new Shape;
//
//    }
    @Override
    public Circle getShape(){
        return  new Circle();


    }

}
