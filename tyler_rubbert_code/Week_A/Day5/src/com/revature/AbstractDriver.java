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
//        Animal noAnimal = new Animal(); // abstract classes cannot be directly instantiated

        System.out.println(myCat.getBreed());
        System.out.println(yourCat.isHasFur());
        System.out.println((hisCat.isHasFur()));
        herCat.makesSound();

        /*
            Covariance is when you have a reference of a super type that points to an object
            of a subtype. this reference will have access to only the states and behaviors
            of the subtype. Although, if any methods of the parent are overridden by the subtype,
            those methods will behave differently.
         */
        System.out.println(myAnimal.numberOfLives);

    }

}
