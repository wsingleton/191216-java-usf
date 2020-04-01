package com.revature.r2;

import java.util.Scanner;

public class NotAmused {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int day = 1;
        String[] enter = new String[40];
        int[] min = new int[40];
        String[] exit = new String[20];
        double[] total = new double[20];
        double cost = .1;
        int a = 0;
        while(sc.hasNextLine()) {
            String str = sc.nextLine();
            if(str.contains("OPEN")){
                continue;
            }else if(str.contains("ENTER")){
                String[] s = str.split(" ");
                enter[a] = s[1];
                min[a++] = Integer.parseInt(s[2]);
            }else if(str.contains("EXIT")) {
                String[] t = str.split(" ");
                enter[a] = t[1];
                min[a++] = Integer.parseInt(t[2]);
            }else {
                for(int i = 0, j = 1; j < a; j++) {
                    if(enter[i].equals(enter[j])) {
                        int y = min[j] - min[i];
                        double z = cost * y;
                        exit[i] = enter[i];
                        total[i] = z;
                        j = ++i + 1;
                    }
                }
                
                System.out.println("Day " + day++);
                for (int w = 0; w < a/2; w++) {
                    if (exit[w].equals("") || exit[w] == null) {
                        break;
                    }else {
                        System.out.println(exit[w] + " $" + total[w]);
                    }
                }
                a = 0;
            }
        }
    }
}
