import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task {

    public void writeToFile(String[] linesToWrite) {


        //verify that the arguments are valid for use
        if(linesToWrite == null || linesToWrite.length == 0){
            return;
        }
        //Wrap risky logic in try/catch and write lines to file
        try{
            //Create the file which will be written to.
            File file = new File("resources/write.txt");
            if(!file.exists()){
                file.createNewFile();
            }
            //Define a file path for the output.
            Path outPath = Paths.get("resources/write.txt");
            //Convert string array into ArrayList for use with the Files methods

            List<String> linesArray = Arrays.asList(linesToWrite);;

            //Write the lines to a file
            Files.write(outPath, linesArray, Charset.defaultCharset());

            //BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file));
        }catch (Exception e){
            e.printStackTrace();
            System.err.println("An unexpected exception occurred.");
        }

    }

}