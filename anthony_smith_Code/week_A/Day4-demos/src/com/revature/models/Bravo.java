package com.revature.models;

public class Bravo extends Alpha {
    /*
            Variable shadowing

                The instance number Alpha.myPublicINt is not easily
                accessible the working within the bravo class. because we have declared
                another instance number with the same name in the subclass.
     */

    public int myPublicInt = 9;

    public void method(){
        int myPublicInt = 10; // this also is variable shadowing
    }

    public int shadowGetter(){
        return super.myPublicInt;
    }

    // Cannot reduce the visibility of inherited methods
    //    @Override // best practice
    //  protected double protectedDoubleGetter() {
    //    return 1.0;
    // }

    //Cannot reduce visibility (package-private[default] is less visiable than )
}
