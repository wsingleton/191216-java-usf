import java.util.Date;

public class Test {
    public static void main(String[] args ){
//        String id = "20 ";
//        String sub = id.substring(0, 1);
//        System.out.println(sub.equals("2"));

//        RecordKeeper data = new RecordKeeper();
////        data.record("300|Boss|Otherboss|Userboss|paascpde");
//        data.getRecord("300");
        Date now = new Date();
        String date = now.toString();
        String format = date.replace(" ", "/");
        String sentence = new String("hi hello 12/10/2019 200");
        String [] pieces = sentence.split(" ", 0);
        String balance = pieces[pieces.length - 1];
//        for(String word: sentence.split(" ", 0)){
            System.out.println(balance);
//        }

    }
}
