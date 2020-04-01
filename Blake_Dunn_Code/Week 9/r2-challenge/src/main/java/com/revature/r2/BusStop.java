package com.revature.r2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BusStop {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
        List<Long> c = new ArrayList<>();
        c.add((long) 1);
        c.add((long) 5);
        c.add((long) 3);
        c.add((long) 2);
        c.add((long) 4);
        c.sort(Long::compareTo);
        System.out.println(c);
//        int tests = sc.nextInt();
//        int test = 1;
//        while(test <= tests) {
//            int stops = sc.nextInt();
//            double people = 1;
//            for (int i = 1; i < stops; i++) {
//
//                if (stops == 1){
//                    break;
//                }
//                people += 0.5;
//                people *= 2;
//            }
//            test++;
//            System.out.println((int) people);
//        }
    }
}
