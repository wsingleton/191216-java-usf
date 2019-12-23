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

        // first check to see if this is valid for use
        if (linesToWrite == null || linesToWrite.length == 0) {
            return;
        }

        //Wrap risky logic in try catch and write lines to a file
        try {
            // Create the file which will be written to
            File writeFile = new File("resources/write.txt");
            if(!writeFile.exists()) writeFile.createNewFile();

            //Define a filepath for the output
            Path outPath = Paths.get("resources/write.txt");

            // Convert the String array into a List for use with file methods
            List<String> linesArray = Arrays.asList(linesToWrite);

            // Write the lines to the file
            Files.write(outPath, linesArray, Charset.defaultCharset());
)
        }
        // handle exceptions
        catch (Exception e) {
            e.printStackTrace();
            System.err.println("An unexpected error occurred.");
        }

    }

}