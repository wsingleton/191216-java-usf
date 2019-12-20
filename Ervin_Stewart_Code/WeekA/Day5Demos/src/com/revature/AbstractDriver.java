package com.revature;
import com.revature.models.*;

public class AbstractDriver {
    public static void main(String[] args){
        Cat myCat = new Cat();
        Cat yourCat = new Cat(8,"Sphinx",false);
        Cat hisCat = new Cat(5, "Persian", true);
        Cat herCat = new Cat(7, "Servel", true);


        Animal myAnimal = new Cat(9, "himalayan", true);
        //Animal noAnimal = new Animal(); // abstract classes cannot be directly instantiated

        System.out.println(myCat.getBreed());
        System.out.println(yourCat.isHasFur());
        System.out.println(hisCat.isHasFur());
        herCat.makeSound();

        /*
        Covariance is when you have a reference of a super type that points to an object of a
        subtype. this referance will have access to only the states and behaviors
        of the super type. Although if any methods of the parent are overriden by the subtype,
        those methods will behave differently
         */


        System.out.println(myAnimal.numberOfLives);
        System.out.println(myAnimal.getNumberOfLives());

        InterfaceImp1 imp1 = new InterfaceImp1();
        imp1.doSomething();;
        imp1.doSomethingCool();

        //interfaces cannot be instantiated (they do not have constructors!)
        //example: InterfaceA interfacea = new Inter

        InterfaceA a = new InterfaceImp1();
        InterfaceB b = new InterfaceImp1();

    }
}
