package com.revature.models;

/* an abstract class is a class that cannot be instantiated on its own
Abstract classes often contain unimplemented methods that must be overridden
by a concrete subclass.

Note, that abstract classes do not necessarily have to have any abstract
methods contained within them. These classes are declared as abstract simply
to prevent their direct instantiation
 */

import java.util.Objects;

public abstract class Animal {
public int numberOfLives = 1;

public Animal(){
    super();// technically not required to be here since it is provided implicity
    System.out.println("Cat constructor called");
}
public Animal(int Lives){
    this.numberOfLives = Lives;
}
/* Abstract methods are methods that have no implementation(body).
They consist only of a method signature, and are often reffered to as a method status
 */

public abstract void makeSound();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return numberOfLives == animal.numberOfLives;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfLives);
    }

/*
note that abstract classes can have methods with implementation.
however, it is still possible for subclasses to override this default implementation

 */

    public int getNumberOfLives() {
        return numberOfLives;
    }

    public void exist(){
    System.out.println("this animal exists");
}

}
