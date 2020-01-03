package com.revature;

import com.revature.pattems.EagerSingleton;
import com.revature.pattems.LazySingleton;

public class SingleTonDriver {
    public static void main(String args[]){

        // the constructor for this class is declared as private as it is not visible
//        LazySingleton ex1_1 = new LazySingleton();

        LazySingleton ex1_2 = LazySingleton.getInstance();
        LazySingleton ex1_3 = LazySingleton.getInstance();

        ex1_2.value = 93;

        System.out.println(ex1_2.value);
        System.out.println(ex1_3.value);
        System.out.println(ex1_2 == ex1_3);

        System.out.println("-------------------------------");

//        EagerSingleton ex2_1 =new EagerSingleton();

        EagerSingleton ex2_2 = EagerSingleton.getInstance();
        EagerSingleton ex2_3 = EagerSingleton.getInstance();

        System.out.println(ex2_2 == ex2_3);

    }
}
