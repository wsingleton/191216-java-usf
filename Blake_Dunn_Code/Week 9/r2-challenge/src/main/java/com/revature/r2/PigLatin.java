package com.revature.r2;

import java.util.Scanner;

public class PigLatin {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextLine()) {
            String str = sc.nextLine();
            String[] s = str.split(" ");
            StringBuilder pig = new StringBuilder();
            for(int i = 0; i < s.length; i++) {
                if(s[i].charAt(0) == 'a' || s[i].charAt(0) == 'e' || s[i].charAt(0) == 'i'
                || s[i].charAt(0) == 'o' || s[i].charAt(0) == 'u' || s[i].charAt(0) == 'y') {
                    pig.append(s[i]);
                    pig.append("yay ");
                }else {
                    for (int j = 1; j < s[i].length(); j++){
                        if(s[i].charAt(j) == 'a' || s[i].charAt(j) == 'e' || s[i].charAt(j) == 'i'
                                || s[i].charAt(j) == 'o' || s[i].charAt(j) == 'u' || s[i].charAt(j) == 'y') {
                            pig.append(s[i].substring(j));
                            pig.append(s[i].substring(0,j));
                            pig.append("ay ");
                            break;
                        }
                    }
                }
            }
            System.out.println(pig);
        }
    }
}
