import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task {

    public void writeToFile(String[] linesToWrite) {

        //verify that the arguments provided are valid for use
        if (linesToWrite == null || linesToWrite.length==0) {
            //allows to break out of method
            return;
        }
        //wrap risky logic in a try/catch, and write the lines to a file
        try{
            //create the file which will be written to.
            File writeFile = new File("resources/write.txt");
            if (!writeFile.exists()) writeFile.createNewFile();

            // Define a file path for the output
            Path outPath = Paths.get("resources/write.text");

            // convert the string array into a list for use with the file methods
            List<String> linesArrlist = Arrays.asList(linesToWrite);
//            ArrayList<String> linesArray = new ArrayList<>();
            Files.write(outPath, linesArrlist, Charset.defaultCharset());
        }

        //handle exceptions

        catch (Exception e) {
            e.printStackTrace();
            System.err.println("An unexpected exception occured.");
        }

    }

}