package com.revature;

// Compare this file with the file on the master branch and update
import com.revature.models.Cat;

import java.util.ArrayList;

public class CollectionDriver {

    public static void main(String[] args) {

        ArrayList objects = new ArrayList();
        objects.add("text");


        //Raw collections (without the use of generics) - everything is an object, always
        objects.add(new Cat());


    }
}
