import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
This class is used to manage the creation of new and writing to files
 */
public class FileManager {

    public void createFile(String name){
        try {
            File files = new File(name);
            if(files.createNewFile()){
                System.out.println("file created! " + files.getName() + "\n" + "Can write? " + files.canWrite());
            } else {
                System.out.println("file creation failed");
            }
        } catch (IOException e){
            System.out.println("Error creating file");
            e.printStackTrace();
        }
    }

    public void write (String text){
        try{
            FileWriter write = new FileWriter("users.txt");
            write.write(text);
            write.close();
            System.out.println("Wrote the following to the file: " + "\n" + text);
        } catch (IOException e){
            System.out.println("Error writing to the file");
            e.printStackTrace();
        }
    }

    public void read (String text){

    }

    public static void main (String[] args){
//        FileManager file1 = new FileManager();
//        System.out.println("Write your message below: ");
//        Scanner input = new Scanner(System.in);
//        String message = input.nextLine();
//        file1.write(message);



    }

}
