package tests;

import models.Account;
import models.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

public class TestClass {

    Account account;

    @Before
    public void setUp() throws IOException {
        File file = new File("resources\\accounts.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();
        line = reader.readLine();
        String [] lineSplit = line.split(",");
        for(int i = 0; i < lineSplit.length; i++){
            System.out.println("lineSplit[i]: "+lineSplit[i]);
        }
        account = new Account(lineSplit[0]);
    }
    @After
    public void tearDown(){
        account = null;
        System.gc();
    }
    @Test
    public void writeDepositTest(){
        account.setAccountAmount(2.0);
        Double d = new Double(2.0);
        String message = "Depositing money" + account.getAccAmount();
        Assert.assertEquals(message, d, account.getAccAmount());

    }
}

