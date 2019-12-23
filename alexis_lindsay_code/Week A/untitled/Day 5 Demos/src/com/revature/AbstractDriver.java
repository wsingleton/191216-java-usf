package com.revature;

import com.revature.models.Animal;
import com.revature.models.Cat;

public class AbstractDriver {

    public static void main(String[] args) {

        Cat myCat = new Cat();
        Cat yourCat = new Cat(8, "Sphinx", false);
        Cat hisCat = new Cat (5, "persian", true);
        Cat herCat = new Cat(7, "Serval", true);

        Animal myAnimal = new Cat(9, "Himalayah", true);

        System.out.println(myCat.getBreed());
        System.out.println(yourCat.isHasFur());
        System.out.println(hisCat.isHasFur());
        System.out.println(myAnimal.numberOfLives);

    }

}
