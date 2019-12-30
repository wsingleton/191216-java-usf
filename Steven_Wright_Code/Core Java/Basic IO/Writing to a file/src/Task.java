import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class Task {


    public void writeToFile(String[] linesToWrite) {

        // Verify that the arguments provided are valid for use
        if (linesToWrite == null) {
            return;
        }

        // Wrap risky logic in a try/catch, and write lines to file - encoded using default charset
        try {

            // Create the file which will be written to
            File writeFile = new File("resources/write.txt");
            //noinspection ResultOfMethodCallIgnored
            writeFile.createNewFile();

            // Define a file path for the output
            Path outPath = Paths.get("resources/write.txt");

            // Convert String array into an ArrayList for use with the Files.write() method
            ArrayList<String> linesArrList = new ArrayList<>(Arrays.asList(linesToWrite));

            // Write the lines to the file
            Files.write(outPath, linesArrList, Charset.defaultCharset());
        }

        // Handle exceptions
        catch (Exception e) {
            e.printStackTrace();
        }            System.err.println("An unexpected exception was thrown.");

    }

}