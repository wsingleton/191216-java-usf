package com.revature;

import com.revature.models.*;

public class AbstractDriver {
    public static void main(String[] args) {
        Cat myCat = new Cat();
        Cat yourCat = new Cat(8, "Sphinx", false);
        Cat hisCat = new Cat(5, "Persian", true);
        Cat herCat = new Cat(7, "Serval", true);

        Animal myAnimal = new Cat(9, "Himalayan", true);
        //Animal noAnimal = new Animal(); //abstract classes cannot be directly instantiated

        System.out.println(myCat.getBreed());
        System.out.println(yourCat.isHasFur());
        System.out.println(hisCat.isHasFur());
        herCat.makeSound();
        //covariance is when you have a reference of a super type
//        that points to an object of a subtype.  This reference will
//        have access to only the states and behaviors of the super type
//        Although, if any methods of the parent are overridden by the
//        subtype, those methods will behave differently.
        System.out.println(myAnimal.numberOfLives);  //covariance

        System.out.println("+------------------------------------+");

        InterfaceImpl impl = new InterfaceImpl();
        impl.doSomething();
        impl.doSomethingElse();

//      Interfaces cannot be instantiated because they do not have constructors.
//      InterfaceA interA = new InterfaceA();

        InterfaceA a = new InterfaceImpl(); //another exp of covariance
        InterfaceB b = new InterfaceImpl();
        a.doSomethingElse();
        b.doSomethingElse();
    }
}
