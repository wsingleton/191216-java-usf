package com.revature;

import com.revature.models.*;

public class AbstractDriver {
    public static void main(String[] args){

        Cat myCat = new Cat();
        Cat yourCat = new Cat(8, "shi", false);
        Cat hisCat = new Cat(5, "Persian", true);
        Cat herCat = new Cat(7, "Serv", true);

        Animal myAnimal = new Cat(9, "Himaylan", true);
      //  Animal noAnimal = new Animal(); // abstract classes cannot be directly instantiated

        System.out.println(myCat.getBreed());
        System.out.println(yourCat.isHasFur());
        System.out.println((hisCat.isHasFur()));
        herCat.makeSound();

        /*
            Covariance is when you have a reference of a super type that point to an
            object of a subtype. THis reference will have access to only the states and
            behaviour of the super type. Although, if any methods of the parent are
            overridden by the subtype, those methods will behave differently.
         */
        System.out.println(myAnimal.numberOfLives); // original numberOfLives from Animal class
      //  System.out.println(myAnimal.getNumberOfLives());

        System.out.println("----------------------");

        InterfaceImpl impl = new InterfaceImpl();
        impl.doSomething();
        impl.doSomethingElse();

        // research Covariance
        // interfaces cannot be instantiated (they dont have constructors)
     //   InterfaceA interfaceA = new InterfaceA();

        InterfaceA a = new InterfaceImpl(); //another example of covariance !!!!
        InterfaceB b = new InterfaceImpl();

        //
        a.doSomethingElse();
        b.doSomethingElse();
    }
}
