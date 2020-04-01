package com.revature.r2;

import java.util.Scanner;

public class ColdScience {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int days = sc.nextInt();
        int[] temps = new int[days];
        int count = 0;
        for(int i = 0; i < days; i++) {
            temps[i] = sc.nextInt();
        }

        for (int i = 0; i < days; i++) {
            if(temps[i] < 0){
                count++;
            }
        }
        System.out.println(count);
    }
}
