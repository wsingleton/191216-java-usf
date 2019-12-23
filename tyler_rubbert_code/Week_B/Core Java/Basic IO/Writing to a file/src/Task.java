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

        // Verify that the arguments provides are valid for use
        if(linesToWrite == null || linesToWrite.length == 0) {
            return;
        }

        // wrap risky logic in a try/catch, and write the lines to a file
        try {
            // Create the file which will be written to
            File writeFile = new File("resources/write.txt");
            if (!writeFile.exists()) writeFile.createNewFile();

            // Define a filepath for the output
            Path outPath = Paths.get("resources/write.txt");

            // Convert the String array into an ArrayList for use with the Files methods
            List<String> linesArrlist = Arrays.asList(linesToWrite);

            // Write the lines to the file
            Files.write(outPath, linesArrlist, Charset.defaultCharset());

        }

        // handle exceptions
        catch (Exception e) {
            e.printStackTrace();
            System.err.println("An unexpected exception has occurred.");
        }

    }

}