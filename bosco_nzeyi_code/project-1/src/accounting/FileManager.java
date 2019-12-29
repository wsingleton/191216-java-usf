package accounting;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/*
This class is used to manage the creation of new and writing to files
 */
public class FileManager {

    public static int id;
    public ArrayList<String> textonFile = new ArrayList<>();
// method to create and write to the file
    public static void writeFile (String fileName, String input){

        // create a file
        String directory = "src/resources/";
        File writeFile = new File(directory + fileName);
        try {
            FileWriter write = new FileWriter(writeFile, true);
            BufferedWriter writer = new BufferedWriter(write);
            writer.write("\n"+ input);
            System.out.println("Input saved");
//            System.out.println("Wrote to the file " + writeFile.getName());
//            System.out.println("Wrote the following to the file: " + "\n" + input);
            writer.close();

        }catch (Exception e){
            e.printStackTrace();
            System.err.println("An error occurred while creating / writing to the file");
        }
    }


    // method to read file
    public void readFile(String fileName){
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
//            System.out.println("the length is " + allLines.size());
            this.textonFile = allLines;
            for(String data: allLines){
                System.out.println(data);
            }
            reader.close();
        }catch (Exception e){
            e.printStackTrace();
            System.err.println("An error occurred");
        }
    }

    public static ArrayList<String> readerTool (String filepath){
        // this method will be used to return an arrayList of file content.
        String directory = "src/resources/";
        File filename = new File(directory + filepath);
        ArrayList<String> content = new ArrayList<>();
        try{
            BufferedReader read = new BufferedReader(new FileReader(filename));
            String lines = read.readLine();
//            ArrayList<String> content = new ArrayList<>();
            while(lines != null){
                content.add(lines);
                lines = read.readLine();
            }

        } catch (Exception e){
            e.printStackTrace();
            System.err.println("An error occurred while trying to read a file");
        }
        // return content array when this method is called
        return content;
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
            id = allLines.size() + 2;
//            System.out.println("the new id is " + id + " which is the the current array size " + allLines.size() + " 2");
            reader.close();
        }catch (Exception e){
            e.printStackTrace();
            System.err.println("An error occurred");
        }
        return id;
    }
}
