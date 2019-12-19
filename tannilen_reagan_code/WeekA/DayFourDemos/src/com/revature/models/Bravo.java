package com.revature.models;

public class Bravo extends Alpha {
    public int myPublicInt=9;
    public void method() {
        int myPublicInt=10;
    }
    public int shadowGetter(){
        return super.myPublicInt;
    }
    @Override //this is not required, but is considered a best practice
    protected double protectedDoubleGetter(){ //cannot reduce the visibility of inherited methods, but you can increase it
        return 1.0;
    }
    @Override
    String packageStringGetter() throws RuntimeException {
        return "a";
    }
}