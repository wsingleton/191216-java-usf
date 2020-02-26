package com.revature;

import java.util.*;

public class Driver {
    public static void main(String[] args) {
        int test, scount = 0;
        String sequence = "CSCSS";
        int shield = 3;
        for(int i = 0; i < sequence.length(); i++) {
            if(sequence.charAt(i) == 'S') scount++;
        }
        if(scount > shield) test = -1;
        else test = BetterSolution(sequence, shield, 0);
        System.out.println(test);
    }

    public static int Solution(String sequence, int shield, int moves) {
        int damage = calculate(sequence);
        String temp;
        if(damage <= shield) return moves;
        if(moves > sequence.length()*sequence.length()) return -1;
        else {
            for(int i = 0; i < sequence.length() - 1; i++) {
                temp = swap(sequence, i);
                if(calculate(temp) <= shield) return ++moves;
                else if(calculate(temp) < damage) return Solution(temp, shield, ++moves);
            }
        }
        return -2;
    }

    public static int BetterSolution(String sequence, int shield, int moves) {
        int damage = calculate(sequence);
        String temp;
        if(damage <= shield) return moves;
        else if(sequence.contains("CS")) {
            temp = swap(sequence, sequence.lastIndexOf("CS"));
            if(calculate(temp) <= shield) return ++moves;
            else return BetterSolution(temp, shield, ++moves);
        }
        else return -1;
    }

    public static int calculate(String sequence) {
        int damage = 0;
        int power = 1;
        for(int i = 0; i < sequence.length(); i++) {
            if (sequence.charAt(i) == 'C') power *= 2;
            if (sequence.charAt(i) == 'S') damage += power;
        }
        //System.out.println(sequence + " damage = " + damage);
        return damage;
    }

    public static String swap(String sequence, int index) {
        StringBuilder tempstring = new StringBuilder(sequence);
        tempstring.setCharAt(index, sequence.charAt(index + 1));
        tempstring.setCharAt(index + 1, sequence.charAt(index));
        return new String(tempstring);
    }


}
