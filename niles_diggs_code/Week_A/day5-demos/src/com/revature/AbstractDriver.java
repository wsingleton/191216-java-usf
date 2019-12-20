package com.revature;

import com.revature.models.Animal;
import com.revature.models.Cat;

public class AbstractDriver {

    public static void main(String[] args) {

        Cat myCat = new Cat();
        Cat yourCat = new Cat(8, "Sphinx", false);
        Cat hisCat = new Cat(5, "Persian", true);
        Cat herCat = new Cat(7, "Serval", true);

        Animal myAnimal = new Cat(9, "Himalayan", true);
     //   Animal noAnimal = new Animal(); // abstract classes cannot be directly instantiated

        System.out.println(myCat.getBreed());
        System.out.println(yourCat.isHasFur());
        System.out.println(hisCat.isHasFur());
        herCat.makeSound();

        System.out.println(myAnimal.numberOfLives); // covariance is when you a reference of a super type that points to and object of a subtype
        // this reference will have access to only the states and behaviors of the super type. Although, if any methods of the parent are overriden
        // by the subtype, those methods will behave differently

    }
}
