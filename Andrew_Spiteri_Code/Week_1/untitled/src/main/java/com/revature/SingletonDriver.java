package com.revature;

import com.revature.patterns.EagerSingleton;
import com.revature.patterns.LazySingleton;

public class SingletonDriver {


    public static void main(String[] args) {
        //The constructor for this class is private.
//        LazySingleton ex_1_1 = new LazySingleton();
        LazySingleton ex1_2 = LazySingleton.getInstance();
        LazySingleton ex1_3 = LazySingleton.getInstance();

        System.out.println(ex1_2.value);
        System.out.println(ex1_3.value);

        ex1_2.value = 2;
        System.out.println(ex1_2.value);
        System.out.println(ex1_3.value);
        System.out.println(ex1_2 == ex1_3);

        //The constructor for this class is private.
//        EagerSingleton ex_2_1 = new EagerSingleton();
        EagerSingleton ex2_2 = EagerSingleton.getInstance();
        EagerSingleton ex2_3 = EagerSingleton.getInstance();

        System.out.println(ex2_2 == ex2_3);


    }
}

