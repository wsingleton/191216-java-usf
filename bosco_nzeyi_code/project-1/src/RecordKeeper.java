import java.util.ArrayList;

public class RecordKeeper {
    /*
    This class is used to Write transaction details to records file.
    The class register the user id, transaction date, transaction type(Withdraw / deposit), and amount.
     */

    // method to record a transaction to record.txt file
    public void record(String folder, String data){
        String directory = "src/resources/";
        folder = directory;
        FileManager.writeFile(folder, data);
    }

    // method that outputs all transaction for a specific user.

    public void getRecord (String id){
        // the file here is record.txt
        // array to hold records
        ArrayList<String> records = FileManager.readerTool("record.txt");

        ArrayList<String> userData = new ArrayList<>();

        // length of the id to check the appropriate equivalence
        int idLength = id.length();


        for(String record: records){
            if(record.substring(0, idLength).equals(id)){
//                userData.add(record);
                // replace the | with space
                String recordString = record.replace("|", " ");
                System.out.println(recordString);
            }
        }


    }

}
