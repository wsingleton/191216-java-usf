package com.revature.models;

public class Bravo extends Alpha {

   /*
   variable shadowing
   The instance member Alpha.myPublicInt is n ot easily accessible when working within the Bravo class.
    because we have declared another instance member with the same name in the subclass.
   */
   public int myPublicInt = 9;

   public void method(){
       int myPublicInt=10;//this also variable shadowing

   }

   public int shadowGetter() {
       return super.myPublicInt;

   }
    //can not redude the visibility of inherited methods
    // @Override
    //  protected  double protectedDoubleGetter(){
    //   return 1.0;
   //  }



    public double protectedDoubleGetter(){
       return 1.0;
    }
//cannot reduce visibility (package-private is less visible than protected)
}

//can not override private methods,since they are not inherited
//@Override
// private char private


@Override
// valid, we can redeclare static methods
public static int publicStaticIntGetter() {
    return 0;
}
//if the inherited method has no throws clause, we can not throw
//throws a checked exception/
// /@Override
//String packageStringGetter()throws Exception{{
//    return "a";
@Override
String packageStringGetter()throws Exception{{
    return "a";

}