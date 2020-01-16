package com.revature.mockbank.screens;

import com.revature.mockbank.exceptions.AuthenticationException;
import com.revature.mockbank.exceptions.InvalidRequestException;
import com.revature.mockbank.services.AccountService;
import com.revature.mockbank.services.UserService;
import com.sun.tools.javac.util.StringUtils;

import static com.revature.mockbank.AppDriver.*;

public class LoginScreen extends Screen {


    private UserService userService;
    private AccountService accountService;

    public LoginScreen(UserService userService, AccountService accountService) {
        super("LoginScreen", "/login");
        System.out.println("[LOG] - Instantiating " + super.getName());
        this.userService = userService;
        this.accountService = accountService;
    }

    @Override
    public void render() {

        String username;
        String password;

        try {

            System.out.println("\n\n\n\n+-----------------------+\n");
            System.out.println("Please provide your login credentials");
            System.out.print("Username: ");
            username = console.readLine();
            System.out.print("Password: ");
            password = console.readLine();

            userService.authenticate(username, password);

            if (currentUser != null) {
                System.out.println("Login successful, navigating to dashboard...");
                accountService.allAccounts(currentUser.getId());

                if(listOfAccounts.isEmpty()){
                    System.out.println("You don't have an active account! ... Taking you to the Account registration screen to create an account");
                    router.navigate("/createAccount");
                } else if (listOfAccounts.size() > 1){
                    System.out.println("You have more than one account. Choose one of the account below to continue");
                    System.out.println(listOfAccounts.toString());
                    String accountSelected = console.readLine();

                    try{

                        if(!isNumeric(accountSelected)) {
                            System.out.println("Invalid selection");
                            //router.navigate("/login");
                        }
                        if(!listOfAccounts.contains(Integer.parseInt(accountSelected))){
                            System.out.println("Invalid selection");
                        }

                        int accOption = Integer.parseInt(accountSelected);
                        if(listOfAccounts.contains(accOption))
                            for(int account : listOfAccounts){
                                if ((accOption == account)){
                                    accountService.setCurrentAccountInUse(account);
                                    router.navigate("/dashboard");
                                }
                            }
                    }catch(InvalidRequestException e){
                        //e.getStackTrace();
                        System.out.println("INVALID INPUT");
                    }
                }
            }
        } catch (InvalidRequestException | AuthenticationException e) {
            System.out.println("[LOG] - Invalid login credentials provided!");
        } catch (Exception e) {
            //System.err.println("[ERROR] - An unexpected exception occurred");
            System.out.println("[LOG] - Shutting down application");
            appRunning = false;
        }
    }

    // validate integer input
    private static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
