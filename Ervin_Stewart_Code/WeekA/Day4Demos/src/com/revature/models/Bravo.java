package com.revature.models;

public class Bravo extends Alpha {

    /* variable shadowing
     the instance member Alpha.myPublicInt is not easily
     accessible when working within the bravo class.
     because we have declared another instance member
      with the same name in the subclass

     */
    public int myPublicInt =9;

    public void method(){
        int myPublicInt =10; // this is also variable shadowing

    }
    public int shadowGetter(){
        return super.myPublicInt;
    }

    //CANNOT REDUCE THE visibility OF INHERiTED METHODS
//    @Override
//    protected double protectedDoubleGetter() {
//        return super.myProtectedDouble();
//    }

//    @Override
//    public double protectedDoubleGetter(){
//        return 1.0;
//    }

    //cannot reduce visibility (package-private is less visible than protected)
  //  @Override
  //  double protectedDoubleGetter(){
   //     return 1.0;
  //  }
    //Cannot override final methods
    /*@Override
    Public final int publicFinalIntGetter(){
        return 0;

    }*/



}
