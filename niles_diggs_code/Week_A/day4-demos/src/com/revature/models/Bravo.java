package com.revature.models;

public class Bravo extends Alpha {

    /*
        Variable shadowing

            The instance member Alpha.myPublicInt is not easily accessible when working with the Bravo class b.c we have
            declared another instance member with the same name in the subclass.

     */
    public int myPublicInt = 9;

    public void method() {
        int myPublicInt = 10; // this is also variable shadowing
    }

    public int shadowGetter() {
        return super.myPublicInt;
    }

    // cannot reduce visibility of inherited methods but you can increase visibility of inherited methods

    // package-private (default) is less visible than protected
    @Override
    public double protectedDoubleGetter() {
        return 1.0;
    }
    // cannot override final methods
    /*@Override
    public final int publicFinalIntGetter() {

    } */
    /*@Override
    private char privateCharGetter() {
        return "q";
    }
    cannot override private methods as they cannot be seen
    */

    private char privateCharGetter() {
        return 'q';
    }
    /* cannot override static methods but they can be re-declared
    @Override
    public static int publicStaticIntGetter() {
        return 0;
    } */

    /*
    @Override
    String packageStringGetter() throws Exception {
        return "a";
    }

    If the inherited method has no throws clause then we cannot throw a checked exception
     */

    // we can add an unchecked exception to the signature
    @Override
    String packageStringGetter() throws RuntimeException {
        return "a";
    }

}
