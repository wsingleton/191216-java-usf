import java.util.ArrayList;

public class Deposit {

    public static void deposit(){
        RecordKeeper record = new RecordKeeper();
        ArrayList<String> userHistory = record.data;
        int lastIndex = userHistory.size() - 1;
        String lastLine = userHistory.get(lastIndex); // to get the last line as it is the one with updated balance

        // get the current balance
        lastLine.trim();
        String [] linePieces = lastLine.split("|");
        int balance = new Integer(linePieces[linePieces.length - 1]);
    }
}
