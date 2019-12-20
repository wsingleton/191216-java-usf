import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.System;
import java.util.Random;
import java.util.Scanner;

public class RegisterUser {
    public static User registerUser() throws IOException{
        Scanner sc = new Scanner(System.in);
        System.out.print("First name: ");
        String firstname =sc.next();
        System.out.print("Last name: ");
        String lastname =sc.next();
        System.out.print("Username: ");
        String username =sc.next();
        System.out.print("Password: ");
        String password =sc.next();

        Random random = new Random();
        random.setSeed(1234567890);

        User user = new User(random.nextInt(),firstname, lastname, username, password, Role.MEMBER);
        FileOutputStream fout=new FileOutputStream("C:\\Users\\Andrew Spiteri\\Documents\\Revature\\Projects\\testout.txt");
        BufferedOutputStream bout=new BufferedOutputStream(fout);
        byte b[] = user.toString().getBytes();
        bout.write(b);
        bout.flush();
        bout.close();
        fout.close();
        return user;
    }
}
