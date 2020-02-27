package com.revature.challenge;

public class Challenge {

    public static boolean testShield(int d, String p) {
        int shoot = 1;
        int total = 0;
        for (int i = 0; i < p.length(); i++) {
            if(p.charAt(i) == 'C'){
                shoot *= 2;
            }else {
                total += shoot;
            }
        }
        return d >= total;
    }


    public static StringBuilder hackRobot (String p) {
        StringBuilder str = new StringBuilder(p);
        int i = p.length()-1;
        for(int j = i; j >= 1; --j) {

            if (str.charAt(j) == 'S' && str.charAt(j - 1) == 'C'){
                str.setCharAt(j, 'C');
                str.setCharAt(j-1, 'S');
                break;
//                j = i;
            }
        }
        return str;
    }

    public static void evaluate(int tc, int s, String r) {
        StringBuilder seq = new StringBuilder(r);
        int hacks = 0;
        boolean maybe = true;
        do {
            if(!r.contains("C") && testShield(s, r)){
                System.out.println("Case #" + tc + ": " + hacks);
                maybe = false;
            }else if (!r.contains("C") && !testShield(s, r)){
                System.out.println("Case #" + tc + ": IMPOSSIBLE");
                maybe = false;
            }
            else if (testShield(s, seq.toString())){
                System.out.println("Case #" + tc + ": " + hacks);
                maybe = false;
            }else if (r.contains("C") && seq.toString().contains("CS")){
                seq = hackRobot(seq.toString());
                hacks++;
            }else {
                System.out.println("Case #" + tc + ": IMPOSSIBLE");
                maybe = false;
            }
        }while(maybe);

    }
}
