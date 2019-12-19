package com.revature.module;

public class Bravo extends Alpha {

    /*
    VAriable chadowing
    thie instance member alpha.myPublicIny is not easily accessible when
    working within the Bravo class, because we have declared another instance
    member with the same name in subclass
     */
    public int myPublicInt = 9 ;
    public void method(){
        int myPublicInt = 10; // this is also variable Shadown
    }

    public int shadownGetter(){
        return super.myPublicInt;
    }

   // @Override
    // cant decrese the visibelity of inner
    //private double protectedDoubleGetter() {
     //   return 1.0;
    //}

    // can increse the visibelity of inner
    @Override
    public double protectedDoubleGetter() {
        return 1.0;
    }


    // Can not overide private method since they are not visible
  //  @Override
   // private char privateCharGetter() {
     //   return this.myPrivateChar;
    //}

    // Can not override static method
    //    public static int publicStaticIntGetter() {
    //        return myPublicStaticInt;
    //    }


    // we can redeclare static methods
    public static int publicStaticIntGetter() {
        return 0;
    }


    // If we inherited method has no throws clause, we can not throw a checked exception
    @Override
    protected String protectedStringThrowsException() throws RuntimeException {
        return "a";
    }

    String packageStringGetter() {
        return "n";
    }



}
