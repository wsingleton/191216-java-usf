package com.revature;
import com.revature.models.Cat;
import com.revature.models.InterfaceImpl;
import com.revature.models.Mammal;

public class AbstractDriver {
    public static void main(String[] args) {
        Cat mabel=new Cat();
        Cat dipper=new Cat();
        Cat cinder=new Cat(0,'s',true,true);
        Cat bobTail=new Cat(9,'m',true,false);
        Mammal goethe=new Cat(7,'m',true,true);
        System.out.println(mabel.numberOfLives);
        System.out.println(bobTail.isHasTail());
        dipper.cry();
        goethe.liveBirths();
        System.out.println("+------------------------------+");
        InterfaceImpl impl= new InterfaceImpl();
        impl.getYourTowel();
        impl.soLong();
    }
}
