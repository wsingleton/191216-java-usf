package com.revature.tier1;

public class SumArray {
    public int sum(int[] array){
        int a = 0 ;

        for (int i = 0 ; i < array.length; i++){
             a= a + array[i];

        }
     return a;
    }
}
