package com.revature;

import java.util.Scanner;

public class WhileTest {

    public static void main(String[] args) {

        /*
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
        } catch(Exception e) { e.printStackTrace(); }

        int check = 0;

        while(check != 4) {
            System.out.println("1) Deposit\n2) Withdraw\n3) Balance\n4) Exit");
            if(!scanner.hasNextInt()) {
                System.out.println("Invalid Option");
                scanner.next();
                continue;
            }
            try {
                check = scanner.nextInt();
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
            if(check <= 0 || check > 4) {
                System.out.println("Invalid Option");
                continue;
            }

            System.out.println(check);
        }

        System.out.println("Escaped");

         */

        Scanner scanner = new Scanner(System.in);
        int check = 0;
        while(check != 2) {
            System.out.print("Enter an integer: ");

            try { check = scanner.nextInt(); }
            catch (Exception e) {
                System.out.println("Not an integer.");
                //e.printStackTrace();
                scanner.next();
                continue;
            }
            System.out.println(check);
        }
    }
}
