package com.revature.models;

public class Bravo extends Alpha {

    /*
        Variable Shadowing

            the instanve member alpha.mypublic in is not easily accessible when
            working within the broaco class. bcause we have declared another instance
            member with the same name in the subclass
     */
    public int myPublicInt = 9;

    public void method() {
            int myPublicInt = 10; //this also variable shadowing
    }
    public int shadowGetter() {
        return super.myPublicInt;

    }
    //cannot reduce the visibility of inherited methods
   // @Override
   // private double protectedDoubleGetter(){
   //     return 1.0;

    @Override
    public double protectedDoubleGetter()
    {
        return 1.0;
    }

    //@Override
 //   double protectedDoubleGetter()
   // {
   //     return 1.0;
 //   }
}

