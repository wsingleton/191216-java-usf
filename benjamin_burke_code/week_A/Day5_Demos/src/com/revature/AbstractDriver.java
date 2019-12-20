package com.revature;

import com.revature.models.*;

public class AbstractDriver {

    public static void main(String[] args){

        Cat myCat = new Cat();
        Cat yourCat = new Cat( 9,"Sphinx", false);
        Cat hisCat = new Cat(5, "Persian", true);
        Cat herCat = new Cat(7, "Seimese", true);

        Animal myAnimal = new Cat(9, "Himilayan", true);
       // Animal noAnimal = new Animal() //abstract classes cannot be directly instantiated
        /*
        covariance is you have a reference of a super type that points to an object of a subtype.
        This is refernce will have access to only the states and behaviors
        of the super type. Although, if my methods of the parent are overridden by the subtype,
        these methods will behave differently.
         */
        System.out.println(myCat.getBreed());
        System.out.println(yourCat.isHasFur());
        System.out.println(hisCat.isHasFur());
        herCat.makeSound();

        System.out.println(myAnimal.numberOfLives); //covariance


        System.out.println("-------------------------------------------------------");


        InterfaceImpl Impl = new InterfaceImpl();
        Impl.doSomething();
        Impl.doSomethingElse();

        InterfaceA a = new InterfaceImpl();
        InterfaceB b = new InterfaceImpl();

        //
        a.doSomethingElse();
        b.doSomethingElse();
    }
}
