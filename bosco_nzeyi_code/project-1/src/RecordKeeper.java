import java.util.ArrayList;

public class RecordKeeper {
    /*
    This class is used to Write transaction details to records file.
    The class register the user id, transaction date, transaction type(Withdraw / deposit), and amount.
     */
    ArrayList<String> data = new ArrayList<>();

    // method to record a transaction to record.txt file
    public void record(String data){
        String filePath = "record.txt";
        FileManager.writeFile(filePath, data);
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
                String recordString = record.replace("|", " ");
                userData.add(record);
                System.out.println(recordString);
            }
        }
        this.data = userData;
        String checkData = userData.isEmpty() ? "No records found to match with your id" : "History found";
        System.out.println(checkData);
    }

//    public void allRecords (){
//        ArrayList<String> records = FileManager.readerTool("record.txt");
//        this.data = records;
//        if(!records.isEmpty()){
//            for (String line: records){
//                System.out.println(line);
//            }
//        }
//    }

}
