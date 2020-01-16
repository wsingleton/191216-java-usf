package com.revature.screens;

import com.revature.exceptions.InvalidRequestException;
import com.revature.exceptions.ResourcePersistentException;
import com.revature.models.Account;
import com.revature.models.User;
import com.revature.repos.AccountRepository;
import com.revature.repos.AccountUserRepository;
import com.revature.services.AccountService;
import com.revature.services.AccountUserService;
import com.revature.services.UserService;

import static com.revature.AppDriver.app;

public class RegisterScreen extends Screen {

    private UserRepository userRepository;
    private AccountRepository accountRepository;
    private AccountUserRepository userAccountRepository;
    private UserService userService;
    private AccountService accountService;
    private AccountUserService accountUserService;

    public RegisterScreen(UserService userService, AccountService accountService, UserAccountService userAccountService, UserRepository userRepository, AccountRepository accountRepository, UserAccountRepository userAccountRepository) {
        super("RegisterScreen", "/register");
        System.out.println("[LOG] - Instantiating " + super.getName());
        this.userService = userService;
        this.accountService = accountService;
        this.accountUserService = accountUserService;
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
        this.accountUserRepository = accountUserRepository;
    }

    @Override
    public void render() {
        String username;
        String password;
        double balance;

        try {

            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Sign up for a new account");
            System.out.println("Username: ");
            username = app().getConsole().readLine();
            System.out.println("Password: ");
            password = app().getConsole().readLine();
            System.out.println("Initial Account Balance: ");

            balance = Double.parseDouble(app().getConsole().readLine());


            User newUser = new User(username, password);
            userService.register(newUser);
            Account newAccount = new Account(balance);
            accountService.registerAccount(newAccount);
            int newUserId;
            User tempUser = userRepository.findUserByUsername(username).get();
            newUserId = tempUser.getUserId();
            int newAccountId;
            Account tempAccount = accountRepository.findByUsername(app().getCurrentSession().getSessionUser().getUsername()).get();
            newAccountId = tempAccount.getAccountId();
            accountUserService.register(newUserId, newAccountId);


            if (app().isSessionValid()) {
                System.out.println("New user Created.  Navigating to user profile screen.");
                app().getRouter().navigate("/select");
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
