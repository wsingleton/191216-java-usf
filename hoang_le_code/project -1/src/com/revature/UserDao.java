package com.revature;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserDao {
    public User myUser;
    List<User> userList = new ArrayList<>();
    public UserDao(){

    }
    public UserDao(User myUser){
        this.myUser= myUser;
    }

    public void saveInfo()throws IOException {
        List<Account> accountList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/com/revature/resources/account.txt"));
            String accountLine = reader.readLine();
            while (accountLine != null) {
                String[] accountFiles = accountLine.split(":");
                Account u = new Account(accountFiles[0], Double.parseDouble(accountFiles[1]));
                accountList.add(u);
                accountLine = reader.readLine();
            }
        } catch (Exception e) {
            System.err.println("an unexcpected exception occurred");
        }

        for (int i = 0; i < accountList.size(); i++) {
            Account account = accountList.get(i);
            if (myUser.getUserName().equals(account.getUserName())) {
                System.out.println(" this username was used, please chose another one");
                return;

            }

        }

        try {


            BufferedWriter writer = new BufferedWriter(new FileWriter("src/com/revature/resources/user.txt", true)  );
            String save = myUser.getFirstName() + ":" + myUser.getLastName()+":"+myUser.getUserName() + ":"
                    + myUser.getPassword();
            writer.write(save);
            writer.newLine();
            writer.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        System.out.println("-----Account created-----  ");

        try {


            BufferedWriter writer = new BufferedWriter(new FileWriter("src/com/revature/resources/account.txt", true)  );
            String save = myUser.getUserName()+ ":"+ 0.0;
            writer.write(save);
            writer.newLine();
            writer.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    public void login(String userName, String pass){
        try{
            BufferedReader reader = new BufferedReader(new FileReader("src/com/revature/resources/user.txt"));
            String userLine = reader.readLine();
            while(userLine != null){
                String[] userFiles= userLine.split(":");
                User u = new User(userFiles[0], userFiles[1],userFiles[2],userFiles[3]);
                userList.add(u);
                userLine = reader.readLine();
            }

        }


        catch(IOException e){
            System.err.println("exception throw while reading file ");
        }

        catch(Exception e){
            System.err.println("an unexcpected exception occurred");

        }
        int check = 0;
        for(User u : userList) {
            if ( userName.equals(u.getUserName()) && pass.equals(u.getPassword())){
                System.out.println("Welcome back " + u.getFirstName() + " " + u.getLastName());

                Account myAcc = new Account();
                AccountDao myAccDao = new AccountDao(myAcc);
                myAccDao.workOnAccount(u.getUserName());
                break;
            }
            else {
                if (check == userList.size() -1){
                    System.out.println(" wrong user name or password");
                }
            }
            check = check + 1;

        }

    }

    public void printFile() throws FileNotFoundException{
        File file =  new File("src/com/revature/resources/user.txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());

        }
    }

}
