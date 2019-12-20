package com.revature;

import com.revature.models.Animal;
import com.revature.models.Cat;

public class AbstractDriver {

    public static void main(String args[]) {

        Cat myCat = new Cat();
        Cat yourCat = new Cat(8,"Spinx", false);
        Cat hisCat = new Cat(5, "Persian", true);
        Cat herCat = new Cat(7, "Serval", true);

        Animal myAnimal = new Cat(9, "Himalayan", true);
        //Animal noAnimal = new Animal(); //abstract classes cannot be directly instantiated

        System.out.println(myCat.getBreed());
        System.out.println(yourCat.isHasFur());
        System.out.println(hisCat.isHasFur());
        herCat.makeSound();

        //Covariance is when you have a reference of a super type that points to an object of a subtype.
        // This reference will have access to only the states and behaviors of the super type.
        // Although, if any methods of the parent are overridden by the subtype. those methods will behave differently.
        //animal can point to cat but cat can't point to animal.

        System.out.println(myAnimal.numberOfLives); // covariance example, even though it's pointing to a cat,
        // it will prioritize the animal fields and methods unless super is called.
        // It has the state of the parent but the behavior of the child(member variables are the parents methods are child's)



    }
}
