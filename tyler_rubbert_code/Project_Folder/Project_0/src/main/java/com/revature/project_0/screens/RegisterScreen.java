package com.revature.project_0.screens;

import com.revature.project_0.exceptions.InvalidRequestException;
import com.revature.project_0.exceptions.ResourcePersistentException;
import com.revature.project_0.models.Account;
import com.revature.project_0.models.AccountType;
import com.revature.project_0.models.User;
import com.revature.project_0.repos.AccountRepository;
import com.revature.project_0.repos.UserRepository;
import com.revature.project_0.services.*;

import static com.revature.project_0.AppDriver.app;

public class RegisterScreen extends Screen {

    private UserRepository userRepository;
    private AccountRepository accountRepository;
//    private UserAccountRepository userAccountRepository;
    private UserService userService;
    private AccountService accountService;
    private UserAccountService userAccountService;

    public RegisterScreen(UserService userService, AccountService accountService, UserAccountService userAccountService, UserRepository userRepository, AccountRepository accountRepository) {
        super("RegisterScreen", "/register");
        System.out.println("[LOG] - Instantiating " + super.getName());
        this.userService = userService;
        this.accountService = accountService;
        this.userAccountService = userAccountService;
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;

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

            // Add new user to the database
            User newUser = new User(username, password, firstname, lastname);
            userService.register(newUser);

            // Add new account made by current user(also new user)
            Account newAccount = new Account(balance, AccountType.CHECKINGS);
            accountService.registerAccount(newAccount);

            int newUserId;

            // use the ids from new user and account to make a user account.
            User tempUser = userRepository.findUserByUsername(username).get();
            newUserId = tempUser.getUserId();
            int newAccountId;
            Account tempAccount = accountRepository.findByUsername(app().getCurrentSession().getSessionUser().getUsername()).get();
            newAccountId = tempAccount.getAccountId();
            userAccountService.register(newUserId, newAccountId);


            if (app().isSessionValid()) {
                System.out.println("New user Created.  Navigating to user profile screen.");
                app().getRouter().navigate("/user");
            }

        } catch (NumberFormatException | InvalidRequestException | ResourcePersistentException e) {
            System.err.println("Registration unsuccessful, invalid values provided or username is taken");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Unexpected error occurred");
            System.out.println("Shutting down application");
            app().setAppRunning(false);
        }
    }
}
