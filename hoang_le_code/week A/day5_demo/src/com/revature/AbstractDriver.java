package com.revature;

import com.revature.model.Animal;
import com.revature.model.cat;

public class AbstractDriver {
    public static void main(String args[]){
        cat myCat = new cat();
        cat yourCat = new cat(5,"aaaa",false);
        cat hisCat = new cat(4,"bbbb",true);
        cat herCat = new cat(7,"cccc",true);

        Animal myAnimal = new cat(9,"ddddd",true);

        System.out.println(myCat.getBread());
        System.out.println(yourCat.isHasfur());
        System.out.println(hisCat.isHasfur());
        herCat.makeSound();


        /*
        coverience is when you have a reference ig a super type that point to an object
        of a subtype, this refernce will have 
         */
        System.out.println(myCat.getBread());
        System.out.println(myCat.getBread());



    }
}
