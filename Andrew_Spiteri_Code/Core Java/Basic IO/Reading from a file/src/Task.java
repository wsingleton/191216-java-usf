import java.io.*;
import java.util.Arrays;

public class Task {

    public String[] getLines(File quoteFile) {

        // Instantiate an array
        String[] lines = new String[0];

        //Check if provided file is valid, if not return empty array
        if(quoteFile == null || !quoteFile.exists() ){
            System.err.println("Invalid file provided!");
            return lines;
        }

        // Use BufferedReader to traverse each line of the file
        try{
            BufferedReader fileReader = new BufferedReader(new FileReader(quoteFile));

            //Obtain first line of the file
            String line = fileReader.readLine();
            //Loop until there are no lines left in the file
            while(line != null){
                //make a new array with an increased capacity of one index
                lines = Arrays.copyOf(lines, lines.length + 1);

                //Add the line into the array, and proceed to the next line of the file
                lines[lines.length - 1] = line;
                line = fileReader.readLine();
            }


        }//handle exceptions
        catch (Exception e){
            System.err.println("An unexpected exception has occurred!");
        }
        return lines;

    }

}
