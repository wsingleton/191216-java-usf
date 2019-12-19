package com.revature.models;

public class Bravo extends Alpha {
    /*
        Variable shadowing
            The instance member alpha.myPublicInt is not easily accessible when working within the
            Bravo class, because we have declared another instance member with the same name in
            the subclass.

     */

    public int myPublicInt = 9;

    public void method() {
        int myPublicInt = 10; //this also variable shadowing
    }

    public int shadowGetter() {
        return super.myPublicInt;
    }

    //Cannot reduce the visibility of inherited methods.
    /*
    @Override
    private double protectedDoubleGetter(){
        return 1.0;
    }
    */

    //Can increase visibility of an inherited method.
    @Override
    public double protectedDoubleGetter() {
        return 1.0;
    }

    //Package-private has less visibility.
    /*
    @Override
    double protectedDoubleGetter(){
        return 1.0;
    }
    */

    //Cannot override inherited final methods
    /*
    @Override
    public final int publicFinalIntGetter(){
        return 0;
    }
    */

    //Cannot Override private method
    /*
    @Override
    private char privateCharGetter(){
        return 'a';
    }
    */

    //Cannot override static methods
    /*
    @Override
    public static int publicStaticIntGetter(){
        return 0;
    }
    */

    //Valid we can redeclare static methods
    public static int publicStaticIntGetter(){
        return 0;
    }

    //If the inherited method has no throws clause, we cannot throw
    //a checked exception.
    /*
    @Override
    String packageStringGetter() throws Exception{
        return "a";
    }
     */

    //However, we can add an unchecked exception to the signature
    @Override
    String packageStringGetter() throws RuntimeException{
        return "a";
    }
}
