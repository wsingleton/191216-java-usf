package com.revature;

import com.revature.models.Animal;
import com.revature.models.Cat;

public class AbstractDriver {

    public static void main (String[] args){
        Cat myCat = new Cat();
        Cat yourCat = new Cat(8, "Sphinx", false);
        Cat hisCat = new Cat(4, "persian", true);

        /*
        We can also use Animal class to instantiate Cat, because Cat is a child of animal.
        Animal is abstract but this AbstractDriver class we are using is  a concreted class.

         */
        Animal myAnimal = new Cat(9, "Himalayan", false);

        // the above method cannot be possible to instatiate an animal because it is abstract.
        // Animal noAnimal = new Animal()

        System.out.println(myCat.getBreed());
        System.out.println(myCat.getHasFur());
        System.out.println(yourCat.getHasFur());

        /*
        Covariance is when you have a reference of super type that points to an object of subtype.

         */

        System.out.println(myAnimal.numberOfLives); // this called covariance. We are calling animal methods from child.

    }
}
