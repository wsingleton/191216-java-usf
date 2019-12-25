import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/*
This class is used to manage the creation of new and writing to files
 */
public class FileManager {

    public static int id;
// method to create and write to the file
    public static void writeFile (String fileName, String input){

        // create a file
        String directory = "src/resources/";
        File writeFile = new File(directory + fileName);
        try {
            FileWriter write = new FileWriter(writeFile, true);
            BufferedWriter writer = new BufferedWriter(write);
            writer.write(input + "\n");
            System.out.println("Wrote to the file " + writeFile.getName());
            System.out.println("Wrote the following to the file: " + "\n" + input);
            writer.close();

        }catch (Exception e){
            e.printStackTrace();
            System.err.println("An error occurred while creating / writing to the file");
        }
    }

    // method to read file
    public static void readFile(String fileName){
    /* this method can be reused if the files to read are stored in the appropriate repository.
    for other repositories, the pathname should be changed to match the appropriate repository.
     */
        String directory = "src/resources/";
        File myFile = new File( directory + fileName);

        try {
            FileReader reader = new FileReader(myFile);
            BufferedReader read = new BufferedReader(reader);
            String lines = read.readLine();
            ArrayList<String> allLines = new ArrayList<String>();
            while (lines != null){
                allLines.add(lines);
//                System.out.println(lines);
                lines = read.readLine();
            }
            System.out.println("the length is " + allLines.size());
            for(String data: allLines){
//                System.out.println(data);
//                data.split(" ");
//                data.indexOf(0);
                // search the 1st empty location in the string
                int indexOfEmpty = data.indexOf(" ");
                System.out.println("first empty in the string is at index " + indexOfEmpty);
                String userId = data.substring(0, indexOfEmpty);
                Integer idInNumber = new Integer(userId);
                System.out.println("The user id is = " + idInNumber);
            }
            reader.close();
        }catch (Exception e){
            e.printStackTrace();
            System.err.println("An error occurred");
        }
    }

    // method to read a file and get id

    public static int getId(){
        File myFile = new File("src/resources/users.txt");
        try {
            FileReader reader = new FileReader(myFile);
            BufferedReader read = new BufferedReader(reader);
            String lines = read.readLine();

            ArrayList<String> allLines = new ArrayList<String>();
            if(allLines.isEmpty()) id = 1;
            while (lines != null){
                allLines.add(lines);
//                System.out.println(lines);
                lines = read.readLine();
            }

            // set the id to 1 if the array is empty
            id = allLines.size() + 1;
            System.out.println("the new id is " + id + " which is the the current array size " + allLines.size() + " 1");
            reader.close();
        }catch (Exception e){
            e.printStackTrace();
            System.err.println("An error occurred");
        }
        return id;
    }
}
