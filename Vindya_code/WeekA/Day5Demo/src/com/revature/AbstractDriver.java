package com.revature;

import com.revature.models.Animal;
import com.revature.models.Cat;
import com.revature.models.Impl;

public class AbstractDriver {
    public static <interfaceImpl> void main(String[] args) {
        Cat myCat = new Cat();
        Cat yourCat = new Cat(8, "sphinx", false);
        Cat hisCat = new Cat(5, "Persian", true);
        Cat herCat = new Cat(7, "Serval", true);

        Animal myAnimal = new Cat();
// Animal noAnimal =new Animal();//abstarct classes cannot be directly instantiated

        System.out.println(myCat.getBreed());
        System.out.println(yourCat.isHasFur());
        System.out.println(hisCat.isHasFur());
        herCat.makeSound();
        System.out.println(myAnimal.numberOfLives);
    /*covariance is when you have a reference of a super type that points to an object of a suject.
    This reference will have access to only the states and behaviours of the super type.
    Although, if any mothods of the parent are overrid by the subtype,those methods will behave differently
     */
        System.out.println(myAnimal.numberOfLives);
        System.out.println(((Cat) myAnimal).getNumberOfLives());
        System.out.println("......+");

        Impl impl = new Impl();
        impl.doSomething();
        impl.doSomethingElse();

      //  interfaces can not be instantiated (they don't have constructors)
    //InterfaceA interfaceA = new InterfaceA();

    }
}

