package com.revature.models;

public class Bravo extends Alpha {

    /*
        Variable Shadowing
            The instance member Alpha.myPublicInt is not easily accessible when working within the Bravo class.
            Because we have declared another instance member with the same name in the subclass.
            To access the shadow variable Alpha.myPublicInt use super.myPublicInt.
     */
    public int myPublicInt = 9;

    public void method(){
        int myPublicInt = 10; //this also variable shadowing. Use this.myPublicInt to get 9.
    }

    public int shadowGetter(){
        return super.myPublicInt;
    }

    // Cannot reduce the visibilty of the inherited methods
//    @Override
//    if we change the access modifier from protected to private
//    private double protectedDoubleGetter() {
//        return 1.0;
//    }

    // we can increase the visibility o


    // private methods are not inherited
}
