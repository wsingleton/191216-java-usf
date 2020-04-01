package com.revature.r2;

import java.util.Scanner;

public class TimeLoop {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int magicNum = sc.nextInt();

        for(int i = 1; i <= magicNum; i++) {
            System.out.println(i + " Abracadabra");
        }
    }
}
