package com.revature.util;

import com.revature.models.Alpha;
import com.revature.models.Circle;
import com.revature.models.Shape;

public class Charlie extends Alpha {

    // Package-private members are not visible beyond the package
    // in which they are declared - even for subclasses!
//    @Override
//    String packageStringGetter() {
//        return "a";
//    }

    // protected members are visible to all subclasses, even if they
    // are located in a different package
    @Override
    protected double protectedDoubleGetter() {
        return 3.14;
    }

    // you cannot override a method by replacing the return type with
    // a completely different type
//    @Override
//    public String getCircle() {
//        return "";
//    }

    // Cannot make the return type of the method a parent class of
    // the inherited method.
//    @Override
//    public Shape getCircle() {
//        return new Shape();
//    }

    // Valid, return types can be changed to a subclass of the original
    // return type of the inherited method.
    @Override
    public Circle getShape() {
        return new Circle();
    }

    // You cannot modify the parameter types of inherited methods
//    @Override
//    public void setShape(Circle circle) {
//
//    }
//
//    @Override
//    public void setShape(Shape shape) {
//
//    }

}
