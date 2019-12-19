package com.revature.Util;

import com.revature.module.Alpha;
import com.revature.module.Circle;
import com.revature.module.Shape;

public class Charlie extends Alpha {


    //You can not overide a method by replacing the return type with a different type
    //    public Circle getCircle() {
    //        return this.myPrivateCircle;
    //    }



    //
//@Override
  //  public Shape getCircle() {
    //    return new Shape();
    //}



    //Return types can be changes in a subclass of the original returntype of the inherited method
    @Override
    public Circle getShape() {
        return new Circle();
    }

//  you cant change the parameter type of inherited method

  //  public void getShape(Circle circle) {

    //}





}
