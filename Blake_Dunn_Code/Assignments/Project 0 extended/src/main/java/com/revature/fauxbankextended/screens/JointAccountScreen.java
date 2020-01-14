package com.revature.fauxbankextended.screens;

import com.revature.fauxbankextended.models.User;
import com.revature.fauxbankextended.services.UserService;

import static com.revature.fauxbankextended.BankDriver.app;

public class JointAccountScreen extends Screen {

    private UserService userService;

    public JointAccountScreen (UserService uService) {
        super("JointAccountScreen", "/joint");
        this.userService = uService;
    }
    @Override
    public void render() {

        System.out.println("\n\n\n\n\n\n\n\n");
        System.out.println("Who would you like to add to your " + app().getCurrentSession().getSessionAccount().getAccountType() +
                " account?");
        System.out.println("Enter the username of new user. ");

        try {
            System.out.print("> ");
            String username = app().getConsole().readLine();
            User newUser = userService.setJointAccount(username);

            System.out.println("You now share your " + app().getCurrentSession().getSessionAccount().getAccountType() +
                    " with " + newUser.getFirstName());

        }catch(Exception e) {
            System.err.println("[ERROR] - " + e.getMessage());
        }

        app().getRouter().navigate("/profile");

    }
}
