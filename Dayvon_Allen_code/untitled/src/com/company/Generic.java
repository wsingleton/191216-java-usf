package com.company;

public class Generic<T> {

    public void genericPrinter(T...arr){
        for (T s: arr
             ) {
            System.out.println(s);
        }
    }
}
