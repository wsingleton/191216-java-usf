package com.revature;

import com.revature.model.*;

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
            Covariance is when you have a reference of a super type that points to an object
            of a subtype. This reference will have access to only the states and behaviors
            of the super type. Although, if any methods of the parent are overridden by the subtype,
            those methods will behave differently.
         */
        System.out.println(myAnimal.numberOfLife);
       // System.out.println(myAnimal.getNumberOfLives());
        System.out.println(".........................");


        InterfaceImp impl = new InterfaceImp();
        impl.doSomeThing();;
        impl.doSomeThingElse();
        // interface cannot be inniciation  because they dont have contructor
        //InterfaceA intfA = new InterfaceA()

        InterfaceA A = new InterfaceImp();
        InterfaceB B = new InterfaceImp();
        A.doSomeThingElse();
        B.doSomeThingElse();


    }
}
