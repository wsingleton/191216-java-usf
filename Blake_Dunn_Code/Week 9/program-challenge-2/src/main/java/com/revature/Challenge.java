package com.revature;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

public class Challenge {

    public Challenge() {
        super();
    }

    public static boolean testShield(int d, String p) {
        System.out.println("Testing");
        int shoot = 1;
        int total = 0;
        for (int i = 0; i < p.length(); i++) {
            System.out.println("test");
            if(p.indexOf(i) == 'C'){
                shoot *= 2;
            }else {
                total += shoot;
            }
        }
        System.out.println(d >= total);
        return d >= total;
    }


    public static StringBuilder hackRobot (String p) {
        StringBuilder str = new StringBuilder(p);
        System.out.println(p.length());
        int i = p.length()-1;
        for(int j = i; j >= 1; --j) {
            System.out.println(i);
            if (str.charAt(i) == 'S' && str.charAt(i - 1) == 'C'){
                str.setCharAt(i, 'C');
                str.setCharAt(i-1, 'S');
                break;
            }
            System.out.println(str);

        }
        return str;
    }

    public static void evaluate(int tc, int s, String r) {

        StringBuilder seq = new StringBuilder(r);
        int hacks = 0;
        boolean maybe = true;
        do {
            if (!r.contains("C") && testShield(s, seq.toString())){
                System.out.println("Case #" + tc + ": IMPOSSIBLE");
                maybe = false;
            }
            if (testShield(s, seq.toString())){
                System.out.println("Case #" + tc + ": " + hacks);
                maybe = false;
            }else {
                seq = hackRobot(seq.toString());
                hacks++;
                System.out.println(hacks);
            }
        }while (maybe);

    }
}
