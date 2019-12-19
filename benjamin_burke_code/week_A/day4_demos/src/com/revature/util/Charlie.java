package com.revature.util;

import com.revature.models.Alpha;
import com.revature.models.Circle;

public class Charlie extends Alpha {

        //package private members are not visible beyond the package
        //in which they are declared - even for subclasses!
//    @Override
//    String packageStringGetter(){
//        return "a";
//    }

    //protected members are visible to all subclasses,even if they
    //are located in a different package
    @Override
    protected double protectedDoubleGetter(){
        return 3.14;
    }

    //You cannot override a method by replacing the return type with
    //a completely different type
//    @Override
//    public String getCircle(){
//        return " ";
//    }

    // We cannot make the return type of the method a parent class of
    // the inherited method.
//    @Override
//    public Shapes getCircle(){
//        return new Shape();
//    }

    //Valid, return type can be changed to a subclass of the original
    //return type of the inherited method
    @Override
    public Circle getShape(){
        return new Circle();
    }

    // You cannot modify the parameter type of inherited methods
//    @Override
//    public void setShape(Circle circle){
//
//    }
//
//    @Override
//    public void setCircles(Shape shape){
//
//    }
}
