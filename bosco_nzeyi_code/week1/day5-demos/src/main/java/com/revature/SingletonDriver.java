package com.revature;

import com.revature.patterns.LazySingleton;

public class SingletonDriver {

    // Singleton design patterns means designing classes that can only instantiate once.
    // If you attempt to create another instate, you will be directed to the instance that is already created.
    /*
    Singleton can be achieved in two ways:
    - lazily,  and
    - eagerly.

    Lazily: I create a class with that I will have to instantiate later.
    Eagerly: That one instance is created ahead of time.
     */
    public int value;

    private SingletonDriver(){
        super();
    }

    public static void main(String[] args){

        // the constructor for this class is declared as private and is not visible.
//        LazySingleton ex1_1 = new LazySingleton();

        LazySingleton ex1_2 = LazySingleton.getInstance();
        LazySingleton ex_3 = LazySingleton.getInstance();

    }
}
