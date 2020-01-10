package rev.challenge.instructions;

import java.util.Scanner;

import rev.challenge.Driver;
import rev.challenge.model.Map;
import rev.challenge.model.Player;

import static rev.challenge.instructions.HelpMe.showInstructions;

public class Menu {

    public static void logo() {
        System.out.println("\t\t\t |||||    |||||   ||||    || ||   ||| ");
        System.out.println("\t\t\t ||  ||   ||      || ||   || ||   |   ");
        System.out.println("\t\t\t ||  ||   |||||   ||||    || ||   | |||");
        System.out.println("\t\t\t ||  ||   ||      || ||   || ||   |  |");
        System.out.println("\t\t\t |||||    |||||   ||||     |||    ||||");
        System.out.println("");
        System.out.println("\t               ||    ||     |||||    ");
        System.out.println("\t              ||||  ||||    ||       ");
        System.out.println("\t              ||  ||  ||    |||||    ");
        System.out.println("\t              ||      ||    ||       ");
        System.out.println("\t              ||      ||    |||||    ");
        System.out.println("");
        System.out.println("+------------------------------------------------------------->");
        System.out.println("");
    }
    public static void menu(Scanner s) {
        boolean success = false;

        do {
            System.out.println("\tSELECT ONE OF THE FOLLOWING");
            System.out.println("(1) START");
            System.out.println("(2) INSTRUCTIONS");
            System.out.println("(3) LEADERBOARD");
            System.out.println("(4) END");
            System.out.println("");
            System.out.println("Type your Selection 1-4:");
            int x = s.nextInt();

            switch (x) {
                case 1:
                    start(s);
                    break;
                case 2:
                    System.out.println("Instructions");
                    showInstructions();
                    System.out.println("");
                    break;
                case 3:
                    System.out.println("Welcome to the Leader Board");
                    System.out.println(Leaderboard.printLeaders());
                    Driver.main(new String[0]);
                    break;
                case 4:
                    System.out.println("Exiting Game");
                    break;
                default:
                    Driver.main(new String[0]);
            }
        }
        while (!success);
        boolean success2 = false;
    }
    private static void start(Scanner s) {
        System.out.println("what is your name?");
        Player p = new Player();
        p.setName(s.next());
        p.setHealth(500.0f);
        System.out.println("here is the Map");
        Map m = new Map(p);
        while(p.getHealth() > 0) {
            System.out.println(m);
            System.out.println("where would you like to move?");
            m.move(s.next());
           // if() {
            //    m.move < spaces || m.move > spaces );
            //}
            //catch (ArrayIndexOutOfBoundsException e) {
             //   System.out.println("hit a wall where would you like to go");
            //}
            m.consequences(s);
        }
        //System.out.println("you lose, get gud nerd");
        //System.exit(0);
    }

}