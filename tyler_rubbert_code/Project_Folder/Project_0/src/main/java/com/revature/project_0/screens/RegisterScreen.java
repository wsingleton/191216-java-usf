package com.revature.project_0.screens;

import com.revature.project_0.exceptions.InvalidRequestException;
import com.revature.project_0.exceptions.ResourcePersistentException;
import com.revature.project_0.models.Account;
import com.revature.project_0.models.AccountType;
import com.revature.project_0.models.User;
import com.revature.project_0.models.UserAccount;
import com.revature.project_0.repos.AccountRepository;
import com.revature.project_0.repos.UserAccountRepository;
import com.revature.project_0.repos.UserRepository;
import com.revature.project_0.services.AccountService;
import com.revature.project_0.services.UserAccountService;
import com.revature.project_0.services.UserService;
import com.revature.project_0.util.UserSession;

import static com.revature.project_0.AppDriver.app;

public class RegisterScreen extends Screen {

    private UserRepository userRepository;
    private UserAccountRepository userAccountRepository;
    private UserService userService;
    private AccountService accountService;
    private UserAccountService userAccountService;

    public RegisterScreen(UserService userService, AccountService accountService, UserAccountService userAccountService) {
        super("RegisterScreen", "/register");
        System.out.println("[LOG] - Instantiating " + super.getName());
        this.userService = userService;
        this.accountService = accountService;
        this.userAccountService = userAccountService;
    }

    @Override
    public void render() {
        String firstname;
        String lastname;
        String username;
        String password;
        double balance;

        try {

            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Sign up for a new account");
            System.out.println("First name: ");
            firstname = app().getConsole().readLine();
            System.out.println("Last name: ");
            lastname = app().getConsole().readLine();
            System.out.println("Username: ");
            username = app().getConsole().readLine();
            System.out.println("Password: ");
            password = app().getConsole().readLine();
            System.out.println("Initial Account Balance: ");

            balance = Double.parseDouble(app().getConsole().readLine());


            User newUser = new User(username, password, firstname, lastname);
            userService.register(newUser);
            Account newAccount = new Account(balance, AccountType.CHECKINGS);
            accountService.registerAccount(newAccount);
            int newUserId;
            User tempUser = userRepository.findUserByUsername(username).get();
            newUserId = tempUser.getUserId();
            int newAccountId;
            Account tempAccount = userAccountRepository.getAccountByUser(tempUser);
            newAccountId = tempAccount.getAccountId();
            userAccountService.register(newUserId, newAccountId);


            if (app().isSessionValid()) {
                System.out.println("New user Created.  Navigating to user profile screen.");
                app().getRouter().navigate("/user");
            }

        } catch (InvalidRequestException | ResourcePersistentException e) {
            System.err.println("Registration unsuccessful, invalid values provided or username is taken");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Unexpected error occurred");
            System.out.println("Shutting down application");
            app().setAppRunning(false);
        }
    }
}
