package com.revature.models;

public class Bravo extends Alpha {

    /*
        Variable shadowing

            The instance member Alpha.myPublicInt is not easily
            accessible when working within the Bravo class,
            because we have declared another instance member
            with the same name in the subclass.
     */
    public int myPublicInt = 9;

    public void method() {
        int myPublicInt = 10; // this is also variable shadowing
    }

    public int shadowGetter() {
        return super.myPublicInt;
    }

    // Cannot reduce the visibility of inherited methods.
//    @Override
//    private double protectedDoubleGetter() {
//        return 1.0;
//    }

    // We can increase the visibility of inherited methods
    @Override
    public double protectedDoubleGetter() {
        return 1.0;
    }

    // Cannot reduce visibility(package-private is less visible
    // than protected)
//    @Override
//    double doubleDoubleGetter() {
//        return 1.0;
//    }

    // Cannot override final methods
//    @Override
//    public final int publicFinalIntGetter() {
//        return 0;
//    }

    // cannot override private methods because we can't see them,
    // however they can be redeclared with no issue.

    // cannot override a static method as they do not belong
    // to the parent class

    //can redeclare a static method


    // if the inherited method has no throws clause,
    // we cannot overload it to throw a checked exception.
//    @Override
//    String packageStringGetter() throws Exception {
//        return "a";
//    }


    // Can add an unchecked exception to the signature
    @Override
    String packageStringGetter() throws RuntimeException {
        return "a";
    }


}
