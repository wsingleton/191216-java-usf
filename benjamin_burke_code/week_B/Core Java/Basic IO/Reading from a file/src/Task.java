import java.io.*;
import java.util.Arrays;

public class Task {

    public String[] getLines(File quoteFile) {

        // Instantiate an array
        String[] lines = new String[0];

        //check if the provided file is valid, if not return an empty array
        if (quoteFile == null || !quoteFile.exists()) {
            System.err.println("Invalid file provided.");
            return lines;
        }

        // Use a BufferedReader to traverse each line of the file
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(quoteFile));

            // obtain the fist line of the file
            String line = fileReader.readLine();


            //Loop until there are no lines left in the file
            while (line != null) {

                // Make a new array with an increased capacity of one index
                lines = Arrays.copyOf(lines, lines.length + 1);

                // Add the line into the array, and proceed to the next line of the file
                lines[lines.length - 1] = line;
                line = fileReader.readLine();
            }

        }
        // handle exceptions
        catch (Exception e) {
            System.err.println("An unexpected exception occurred.");

        }

        return lines;

    }

}
