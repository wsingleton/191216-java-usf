package com.revature.models;

public class Bravo extends Alpha {
    /*
        Variable Shadowing, providing a duplicate of something that
        is already inherited, without actually changing it.
        The instance member Alpha.myPublicInt is not easily accessible when working
        within the Bravo class, bc we have declared another instance member
        with the same name in the subclass.

     */
    public int myPublicInt = 9;

    public void method() {
        int myPublicInt = 10; // this also variable shadowing

    }

    public int shadowGetter(){
        return super.myPublicInt;
    }

    //Cannot reduce the visibility of inherited methods
//    @Override
//    private double protectedDoubleGetter() {
//        return 1.0;
//    }

    // We can increase the visibility of inheritance method
//    @Override
//    public double protectedDoubleGetter() {
//        return 1.0;
//    }

    //Cannot reduce visibility (package-private is less visible)
//    @Override
//    double protectedDoubleGetter(){
//        return 1.0;
//    }
    //Cannot override inherited final methods
//    @Override
//    public final int publicFinalIntGetter(){
//        return 0;
//    }

   // Cannot override private methods, since they are not inherited
//    @Override
//    private char privateCharGetter(){
//        return 'a';
//    }

    //valid because it isn't actually overriding anything just re-declaring it
    private char privateCharGetter(){
        return 'a';
    }

    //Cannot override static methods
//    @Override
//    public static int publicStaticIntGetter(){
//        return 0;
//    }

    //Valid we can redeclare static methods
    public static int publicStaticIntGetter(){
        return 0;
    }

    //if the inheritance method has no throws clause, we cannot
    //throw a checked exception
//    @Override
//    String packageStringGetter() throws Exception {
//        return "a";
//    }

    String packageStringGetter() throws RuntimeException {
        return "a";
    }
}
