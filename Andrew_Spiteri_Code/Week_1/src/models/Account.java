package models;

import java.io.*;

import java.nio.file.Files;
import java.text.DecimalFormat;
import java.util.*;


public class Account {
    private String accountNo, id;
    private Double accountAmount;// need to ensure precision to two decimal places
    private Integer accountNoHolder;


    Random random = new Random(1234567890);

    public Account(String accountNo, String id, Double accountAmount) {
        this.accountNo = accountNo;
        this.id = id;
        this.accountAmount = accountAmount;
    }

    public Account(String id){
        this.id = id;
        this.accountNo = getAccountNo(id);
        this.accountAmount = getAccountAmount(id);
    }

    Account(String id, Double accountAmount){
        this.id = id;
        this.accountAmount = accountAmount;
        this.accountNoHolder = random.nextInt();
        this.accountNo = accountNoHolder.toString();
    }
    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo){
        this.accountNo = accountNo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getAccAmount() {
        return accountAmount;
    }

    public void setAccountAmount(Double accountAmount) {
        this.accountAmount = accountAmount;
        DecimalFormat df = new DecimalFormat("0.00");
        File accountFile = new File("resources\\accounts.txt");
        File tempFile = new File("resources\\temp.txt");
        try(BufferedWriter tempWriter = new BufferedWriter(new FileWriter(tempFile,true))){
            BufferedReader reader = new BufferedReader(new FileReader(accountFile));
            for(String line; (line = reader.readLine())!= null;) {
                String [] strArr = line.split(";");
                for (int j = 0; j < strArr.length; j++) {
                    String[] finalArr = strArr[j].split(",");
                    if (finalArr[0].equals(this.id)) {
                        tempWriter.write(finalArr[0] + "," + finalArr[1] + "," + accountAmount.toString() + ";");
                    } else {
                        String temp = finalArr[0] + "," + finalArr[1] + "," + finalArr[2] + ";";
                        tempWriter.write(temp);
                    }
                }
            }
//            FilePath tempPath = new FilePath("C:\\Users\\Andrew Spiteri\\Documents\\Repos\\191216-java-usf\\Andrew_Spiteri_Code\\Week_1\\resources\\temp.txt");
//            FilePath accountsPath = new FilePath("C:\\Users\\Andrew Spiteri\\Documents\\Repos\\191216-java-usf\\Andrew_Spiteri_Code\\Week_1\\resources\\accounts.txt");
//            Path path;

            tempWriter.flush();
            tempWriter.close();
            reader.close();
            Files.deleteIfExists(accountFile.toPath());
            Files.copy(tempFile.toPath(), accountFile.toPath());
            Files.deleteIfExists(tempFile.toPath());


        }catch (IOException ioe){
            ioe.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public String toFileString(){
        id = id.replace('-', ' ');
        id.trim();
        accountNo = accountNo.replace('-', ' ');
        accountNo.trim();
        String fileString = id + "," + accountNo + "," + accountAmount;
        return fileString;
    }

    public Account createAccount(String id, Double accountAmount){
        return new Account(id, accountAmount);
    }

    public String getAccountAmount(Account account){
        DecimalFormat df = new DecimalFormat("#.##");
        File accountFile = new File("resources\\accounts.txt");
        try(BufferedReader reader = new BufferedReader(new FileReader(accountFile))){
            for(String line;(line = reader.readLine()) != null;) {
                String[] lineSplit = line.split(";");
                for (int j = 0; j < lineSplit.length; j++) {
                    String[] finalArr = lineSplit[j].split(",");
                    if(finalArr[0].equals(id)){
                        return finalArr[2];
                    }
                }
            }
        }catch (IOException ioe){
            ioe.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }

    public static Double getAccountAmount(String id){
        DecimalFormat df = new DecimalFormat("#.##");
        File accountFile = new File("resources\\accounts.txt");
        try(BufferedReader reader = new BufferedReader(new FileReader(accountFile))){
            for(String line;(line = reader.readLine()) != null;) {
                String [] strArr = line.split(";");
                for (int j = 0; j < strArr.length; j++) {
                    String[] finalArr = strArr[j].split(",");
                    if(finalArr[0].equals(id)){
                        Scanner sc = new Scanner(finalArr[2]);
                        return sc.nextDouble();
                    }
                }
            }
        }catch (IOException ioe){
            ioe.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0.0;
    }

    public static String getAccountNo(String id){
        DecimalFormat df = new DecimalFormat("#.##");
        File accountFile = new File("resources\\accounts.txt");
        try(BufferedReader reader = new BufferedReader(new FileReader(accountFile))){
            for(String line; (line = reader.readLine()) != null; ){
                String [] strArr = line.split(";");
                for (int j = 0; j < strArr.length; j++) {
                    String[] finalArr = strArr[j].split(",");
                    if(finalArr[0].equals(id)){
                        return finalArr[1];
                    }
                }
            }
        }catch (IOException ioe){
            ioe.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Double.compare(account.accountAmount, accountAmount) == 0 &&
                accountNo.equals(account.accountNo) &&
                id.equals(account.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNo, id, accountAmount);
    }

    @Override
    public String toString() {
        return accountNo;
    }


}
