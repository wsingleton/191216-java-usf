package com.revature;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HillNumber {

    public static void main(String[] args){

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(String.valueOf(input.toString()));
        char[] charArr = input.toString().toCharArray();

        if(number<0){
            System.out.println("Not a valid input");
            return;
        }

        for(int i = 1; i < charArr.length; i++){

            if (charArr[i-1] < charArr[i]){
                System.out.println("given number" + charArr[i]);
            }
        }


    }
}
