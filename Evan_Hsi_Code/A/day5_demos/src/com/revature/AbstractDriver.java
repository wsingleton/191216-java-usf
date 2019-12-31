package com.revature;

import com.revature.models.*;

import java.util.Scanner;

public class AbstractDriver {

    public static void main(String[] args) {
        Cat myCat = new Cat();
        Cat yourCat = new Cat(8, "Sphinx", false);
        Cat hisCat = new Cat(5, "Persian", true);
        Cat herCat = new Cat(7, "Serval", true);
        Animal myAnimal = new Cat(9, "Himalayan", true);

        System.out.println(myCat.getBreed());
        System.out.println(hisCat.isHasFur());
        System.out.println(myAnimal.numberOfLives);
        System.out.println(myAnimal.getNumberOfLives());
        System.out.println(myAnimal.toString());

        System.out.println("----------------------------------------");

        InterfaceImpl impl = new InterfaceImpl();
        impl.doSomething();
        impl.doSomethingElse();
        InterfaceA a = new InterfaceImpl(); //covariance
        InterfaceB b = new InterfaceImpl();

        a.doSomethingElse();
        b.doSomethingElse();
    }
}
