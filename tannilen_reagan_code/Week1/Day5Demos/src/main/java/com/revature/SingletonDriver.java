package com.revature;

import com.revature.patterns.LazySingleton;

public class SingletonDriver {
    public static void main(String[] args) {
        LazySingleton ex_1=LazySingleton.getInstance();
        LazySingleton ex_2=LazySingleton.getInstance();
        System.out.println(ex_1);
        System.out.println(ex_2);
    }
}
