package com.revature.r2;

import java.util.Scanner;

public class PlaninaChallenge {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int iteration = sc.nextInt();
        int points = 0;
        int  num = 2;
        int n = 0;
        for(int i = 1; i <= iteration; i++){
            num += Math.pow(2, n++);
            points = (int)(Math.pow(num, 2));
            if(i == iteration){
                System.out.println(points);
            }
        }
    }
}
