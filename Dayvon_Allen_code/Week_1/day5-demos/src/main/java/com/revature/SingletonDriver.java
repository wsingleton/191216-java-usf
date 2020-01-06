package com.revature;

import com.revature.patterns.EagerSingleton;
import com.revature.patterns.LazySingleton;

public class SingletonDriver {
    //private access, you cannot invoke it
//    LazySingleton ex1_1 = new LazySingleton();

    public static void main(String[] args) {
        //the references point to the exact same object in memory
        LazySingleton ex1_2 = LazySingleton.getInstance();

        LazySingleton ex1_3 = LazySingleton.getInstance();
        System.out.println(ex1_2.value);
        System.out.println(ex1_3.value);

        ex1_2.value = 93;

        System.out.println(ex1_2.value);
        System.out.println(ex1_3.value);
        System.out.println(ex1_2.value == ex1_3.value);


        EagerSingleton ex1_4 = EagerSingleton.getInstance();
        EagerSingleton ex1_5 = EagerSingleton.getInstance();

        System.out.println(ex1_4 == ex1_5);



    }


}
