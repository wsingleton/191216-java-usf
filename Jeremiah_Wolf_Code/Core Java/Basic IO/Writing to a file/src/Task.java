import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class Task {

    public void writeToFile(String[] linesToWrite) {

        //Verify that the arguments that are provided are valid for use
        if (linesToWrite == null || linesToWrite.length ==0) {
            return;
        }

        //wrap risky logic in a try/catch, and write the lines to the file
        try{
            //create the file which will be written to
            File writeFile = new File ("resources/write.txt");
            if (!writeFile.exists()) writeFile.createNewFile();

            //define a filepath for the output
            Path outPath = Paths.get("resources/write.txt");

            //Convert the String into a List for use with the files methods
            Arrays.asList(linesToWrite);
            ArrayList<String> linesArray = new ArrayList<>();

            //Write the lines to the file
            Files.write(outPath, linesArray, Charset.defaultCharset());
        }

        catch(Exception e) {
            e.printStackTrace();
            System.out.println("An unexpected exception occurred.");
        }

    }

}