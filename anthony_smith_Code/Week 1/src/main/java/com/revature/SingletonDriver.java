package com.revature;

import com.revature.patterns.LazySingleton;

public class SingletonDriver {

    public static void main(String[] args) {

     //   LazySingleton ex1_1 = new LazySingleton()[]
        //  the constructor for this class is declared as private and is not visiable

        LazySingleton ex1_2 = LazySingleton.getInstance();
        LazySingleton ex1_3 = LazySingleton.getInstance();

        System.out.println(ex1_2.value);
        System.out.println(ex1_3.value);

        ex1_2.value = 93;

        System.out.println(ex1_2.value);
        System.out.println(ex1_3.value);
        System.out.println(ex1_2 == ex1_3);

    }
}
