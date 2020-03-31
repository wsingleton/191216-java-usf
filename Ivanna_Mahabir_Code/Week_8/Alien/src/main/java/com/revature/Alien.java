package com.revature;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Alien {

    /*
    * Greedy Problem minimized number of hacks or changes
    * notice that the least damage occurs when the C's are stacked
    * at the end of the string.
    * (medium)
    *
    * */
    public static int calcDamage(char arr[]){
        int damage = 1;
        for (int j=2; j<arr.length ; j++){
            if (String.valueOf(arr[j]).equals("C")){
                damage = damage *2;
                System.out.println("Charge the beam, doubling the beam's strength to" + damage);
            }
            else{
                System.out.println("Shoot the beam, doing" + damage + "damage");
                return damage;
            }
        }
        return damage;
    }

    public static int swapOP(char arr[]){
        int countSw = 0;
        for(int j=3; j<arr.length; j++){
            if(String.valueOf(arr[j-1]).equals("C") && String.valueOf(arr[j]).equals("S")) {
                char temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
             countSw++;
            }
            else {
                countSw = -1;
            }
        }
        return countSw;
    }



    public static void main(String[] args) throws IOException {

        System.out.println("Enter number of test cases: ");
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(String.valueOf(input));
        if (testcase < 0 || testcase > 101){
            System.out.println("Invalid input");
            return;
        }
        System.out.println("Shield strength and Alien attack: \n");
        String shieldAttack = input.readLine();
        for(int i = 1; i<testcase; i++) {
            char[] seq = shieldAttack.toCharArray();
            int shield = Integer.parseInt(String.valueOf(seq[0]));

            while(shield < calcDamage(seq)){
                if(swapOP(seq) == -1) {
                    break;
                }

            }
            if(shield < calcDamage(seq)){
                swapOP(seq);
                System.out.println("Goodbye");
            }
        }
    }
}
