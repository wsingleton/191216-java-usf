package com.revature.util;

import com.revature.models.Alpha;
import com.revature.models.Circle;
import com.revature.models.Shape;

public class Charlie extends Alpha{

   //Protected members are visible to all subclasses,
   //even if they are in a different package.
   @Override
   protected double protectedDoubleGetter() {
       return 3.14;
   }

   //cannot override a method by replacing the return type with
    // a completely different type
 //  @Override
 //   public Circle getCircle() {
 //      return "";
 //   }

    //a shape can be any shape not necessarily a circle.
    //cannot make the return type of the method a parent class
    // of the inherited method.
/*    @Override
    public Shape getCirle() {
       return new Shape();
    }
*/
    // a circle can be treated as a shape
    //Valid, return types can be changed to a subclass of the
    //original return type of the inherited method.
    @Override
    public Circle getShape() {
        return new Circle();
    }

    //Cannot modify the parameter types of the inherited methods
//    @Override
//    public void setShape(Circle circle){

//    }



}
