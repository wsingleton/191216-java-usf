package rev.challenge.instructions;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import rev.challenge.model.User;

public class Leaderboard {

    private static List<User> leaders;


    @SuppressWarnings("unchecked")
    public static void load() {
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("./leader.txt"));) {
            leaders = (List<User>) input.readObject();
        } catch (IOException e) {
            initialize();
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void save() {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("./leader.txt"));) {
            output.writeObject(leaders);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static String printLeaders() {
        organize();
        String line = "";
        for (User u : leaders) {
            line += u.toString() + "\n";
        }
        return line;
    }

    private static void organize() {
        Collections.sort(leaders);
        for (int i = 0; i < leaders.size(); i++) {
            leaders.get(i).setPlace(i + 1);
        }
    }

    public static void add(User u) {
        leaders.add(u);
        organize();
        for (User user : leaders) {
            if (user.getPlace() > 10) {
                leaders.remove(user);
            }
        }
    }

    public static void initialize() {
        leaders = new ArrayList<>();
        add(new User("fake", 0));
        add(new User("fake", 0));
        add(new User("fake", 0));
        add(new User("fake", 0));
        add(new User("fake", 0));
        save();
    }

}