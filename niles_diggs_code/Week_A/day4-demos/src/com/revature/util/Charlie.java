package com.revature.util;

import com.revature.models.Alpha;
import com.revature.models.Circle;
import com.revature.models.Shape;

public class Charlie extends Alpha {

    /* even subclasses cannot override the default/ package-private
    @Override
    String packageStringGetter() {
        return "a";
    }
    */

    // protected members are visible to all subclasses, even if they are located in a different package
    @Override
    protected double protectedDoubleGetter() {
        return 3.14;
    }
    // Cant override a  method by replacing the return type with a completely different type
    /*@Override
    public String getCircle() {
        return "";

    }
    */

    /*  return types cannot be changed to a super class of the original return type
    @Override
    public Shape getCircle() {
        return new Shape();
    }

     */

    // return types can be changed to a subclass of the original return type of the inherited method
    @Override
    public Circle getShape() {
        return new Circle();
    }


    /*
    @Override
    public void getShape(Shape shape) {

    }
    You can't change the parameters
     */

}
