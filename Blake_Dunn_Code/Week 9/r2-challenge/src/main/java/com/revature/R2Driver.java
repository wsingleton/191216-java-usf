package com.revature;

import com.revature.r2.R2Challenge;

public class R2Driver {

    public static void main(String[] args) {
        int n = 24;
        isEven(n);

    }

    public static void isEven(int n){
        if(n % 2 == 0 && (n > 20 || (n >= 2 && n <= 5))) {
            System.out.println("Not Weird");
        }else if (n % 2 == 0 && n > 5 && n <= 20) {
            System.out.println("Weird");
        }else {
            System.out.println("Weird");
        }
    }
}
