public class Try {

    public static void main (String ... args){

        AccountManager accountManager = new AccountManager();
        accountManager.transaction(17, "withdraw");
//        accountManager.getBalance(17);

//        RecordKeeper records = new RecordKeeper();
//        records.getRecord("17");

    }
}
