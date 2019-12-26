package com.revature;

import com.revature.models.Box;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CompareDriver {

    public static void main (String [] args) {

        Box myBox = new Box(50.0, "brown");
        Box yourBox = new Box(45.5, "white");

        Box[] boxes = {myBox, new Box(3.5, "red"), yourBox};
        Arrays.sort(boxes);

        for (Box box : boxes) {
            System.out.println(box);
        }
    }
}
