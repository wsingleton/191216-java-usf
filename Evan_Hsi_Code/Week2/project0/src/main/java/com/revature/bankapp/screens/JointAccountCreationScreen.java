package com.revature.bankapp.screens;

import com.revature.bankapp.models.Type;
import com.revature.bankapp.services.AccountService;

import java.io.IOException;
import java.sql.SQLException;

import static com.revature.bankapp.BankDriver.*;

public class JointAccountCreationScreen extends Screen{

    private AccountService accountService;

    public JointAccountCreationScreen() {
        super("JointAccountCreationScreen", "/jacs");
        System.out.println("[LOG] - Instantiating " + super.getName());
    }

    public JointAccountCreationScreen(AccountService accountService) {
        super("JointAccountCreationScreen", "/jacs");
        System.out.println("[LOG] - Instantiating " + super.getName());
        this.accountService = accountService;
    }

    @Override
    public void render() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

        boolean run = true;
        while(run) {
            try {

                System.out.print("1) View All Accounts\n" +
                        "2) View Joint Accounts\n" +
                        "3) Add User to Account\n" +
                        "4) Back\n" +
                        "> ");

                String userChoice = console.readLine();
                switch (userChoice) {
                    case "1":
                        System.out.println(accountService.findAllByUser(userid));
                        break;
                    case "2":
                        System.out.println(accountService.findAllJoint());
                        break;
                    case "3":
                        System.out.println("Enter Account ID");
                        String ids = "";
                        try {
                            ids = console.readLine();
                        } catch (IOException e) { e.printStackTrace(); }
                        int id = Integer.parseInt(ids);
                        if(accountService.owner(id))
                            accountService.addUserToAccount(id);
                        else System.out.println("You do not own this account");
                        break;
                    case "4":
                        run = false;
                        appRunning = false;
                        break;
                    default:
                        System.out.println("[LOG] - Invalid selection!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
