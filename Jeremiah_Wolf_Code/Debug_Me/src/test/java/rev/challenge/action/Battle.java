package rev.challenge.action;

import java.util.Scanner;

import rev.challenge.model.Enemy;
import rev.challenge.model.Player;

public class Battle {

    public static void battle(Player p, Enemy e, Scanner scan) {
        while (e.getHealth() > 0&&p.getHealth()>0) {
            System.out.println("heal or attack");
            String str = scan.next();
            if (str.equals("heal")) {
                playerHeal(p);
            } else if (str.equals("attack")) {
                playerAttack(p, e);
            } else {
                System.out.println("invalid");
            }
            EnemyAttack(p, e);
        }

    }

    private static void playerAttack(Player p, Enemy e) {
        int x = (int) Math.round(Math.random());
        boolean b = x == 1 ? true : false;
        double d = p.getWeapon().getDamage();
        if (b) {
            e.setHealth(e.getHealth() - (int) d);
            System.out.println("you dealt " + d + "damage");
        }else System.out.println("you missed your attack");
        System.out.println("the enemies new health is " + e.getHealth());
    }

    private static void EnemyAttack(Player p, Enemy e) {
        int x = (int) Math.round(Math.random());
        boolean b = x == 1 ? true : false;
        if (!b) {
            p.setHealth((float)(p.getHealth() - e.getStrength()));
            System.out.println("you took " + e.getStrength() + " damage");
        } else System.out.println("the enemy missed their attack");
        System.out.println("your new health is " + p.getHealth());

    }

    private static void playerHeal(Player p) {
        System.out.println("your current health is " + p.getHealth());
        p.setHealth((float) (p.getHealth() + Math.random() * 5));
        System.out.println("your new health is " + p.getHealth());
    }


}