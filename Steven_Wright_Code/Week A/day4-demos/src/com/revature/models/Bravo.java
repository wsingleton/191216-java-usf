package com.revature.models;

public class Bravo extends Alpha {


    /*
        Variable shadowing

         The instance member Alpha.myPublicInt is not easily accessible when working within the bravo class, because we
         have declared another instance member with the same name in the subclass.
     */


    public int myPublicInt = 9;

    public void method() {
        int myPublicInt = 10; // this also variable shadowing

    }

    public int shadowGetter()  {
        return super.myPublicInt;
    }
    // Cannot reduce the visibility if inherited methods
   // @Override
   // private double protectedDoubleGetter() {
     //   return 1.0;
    }

    //We can increase the vi
}


