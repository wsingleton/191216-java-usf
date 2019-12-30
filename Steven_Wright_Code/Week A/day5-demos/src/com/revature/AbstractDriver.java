package com.revature;

import com.revature.models.*;


public class AbstractDriver {


    public static void main(String[] args) {

        Cat myCat = new Cat();
        Cat yourCat = new Cat(8, "Sphinx", false);
        Cat hisCat = new Cat(5, "Persian", true);
        Cat herCat = new Cat(7, "Servial", true);

        Animal myAnimal = new Cat(9, "Himalayan", true);
        // Animal noAnimal = new Animal(); //abstract classes cannot be directly instantiated


        System.out.println(myCat.getBreed());
        System.out.println(yourCat.isHasfur());
        System.out.println(hisCat.isHasfur());
        herCat.makeSound();




        System.out.println(myAnimal.numberOfLives);  // covarlance
        System.out.println(myAnimal.getNumberOfLives());

        System.out.println("-------------------------");

        InterfaceImpl impl = new InterfaceImpl();
        impl.doSomething();
        impl.doSomethingElse();

        //interfaces cannot be instantiated (they don't have constructors!)
                 // InterfacesA interfaceA = new InterfaceA()

        InterfaceA a = new InterfaceImpl();
        InterfaceB b = new InterfaceImpl();

        //both print out see
    }
}
