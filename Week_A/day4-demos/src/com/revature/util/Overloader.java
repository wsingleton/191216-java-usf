package com.revature.util;

public class Overloader {

    public void method(int i) {
        System.out.println("Primitive type int value: " + i);
    }

    public void method(Integer i) {
        System.out.println("Integer object value: " + i);
    }

    public void method(long i) {
        System.out.println("Primitive type long value: " + i);
    }

    public void method(int... i) {
        System.out.println("Variable arguments");
    }

    public void method(float i) {
        System.out.println("Primitive type float value: " + i);
    }

    public void method(double i) {
        System.out.println("Primitive type double value: " + i);
    }

    public void method(Double i) {
        System.out.println("Double object value: " + i);
    }

    public void method(Float i) {
        System.out.println("Float object value: " + i);
    }
}
