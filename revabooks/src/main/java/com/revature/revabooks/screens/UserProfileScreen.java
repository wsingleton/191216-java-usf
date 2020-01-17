package com.revature.revabooks.screens;

import com.revature.revabooks.exceptions.AuthorizationException;
import com.revature.revabooks.exceptions.InvalidRequestException;
import com.revature.revabooks.exceptions.ResourcePersistenceException;
import com.revature.revabooks.models.User;
import com.revature.revabooks.services.UserService;

import java.io.IOException;

import static com.revature.revabooks.AppDriver.*;

public class UserProfileScreen extends Screen {

    private UserService userService;

    public UserProfileScreen(UserService userService) {
        super("UserProfileScreen", "/profile");
        System.out.println("[LOG] - Instantiating " + super.getName());
        this.userService = userService;
    }

    @Override
    public void render() {

        boolean loopMenu = true;

        while (loopMenu) {
            String userSelection;

            System.out.println("\n\n+---------------------------------+\n");
            System.out.println(app().getCurrentSession().getSessionUser());
            System.out.println("\n1) Change password");
            System.out.println("2) Edit first name");
            System.out.println("3) Edit last name");
            System.out.println("4) Back to Dashboard");

            try {

                // Get user's menu selection
                System.out.print("Selection: ");
                userSelection = app().getConsole().readLine();

                switch (userSelection) {
                    case "1":
                        changeProfileInfo("password");
                        break;
                    case "2":
                        changeProfileInfo("first name");
                        break;
                    case "3":
                        changeProfileInfo("last name");
                        break;
                    case "4":
                        System.out.println("Returning to dashboard...");
                        loopMenu = false;
                        break;
                    default:
                        System.out.println("Invalid selection!");
                        loopMenu = false;
                }
            } catch (Exception e) {
                System.err.println("[ERROR] - " + e.getMessage());
                System.out.println("[LOG] - Shutting down application");
                loopMenu = false;
                app().setAppRunning(false);
            }
        }
    }

    private void changeProfileInfo(String selection) throws IOException {

        String currentPassword;
        String newInfo;

        System.out.print("Current password: ");
        currentPassword = app().getConsole().readLine();

        if (!app().getCurrentSession().getSessionUser().getPassword().equals(currentPassword)) {
            System.out.println("Invalid password, returning to Edit Profile screen");
            return;
        }

        System.out.print("New " + selection + ": ");
        newInfo = app().getConsole().readLine();

        User updatedUser = new User(app().getCurrentSession().getSessionUser());

        switch (selection) {
            case "password":
                updatedUser.setPassword(newInfo);
                break;
            case "first name":
                updatedUser.setFirstName(newInfo);
                break;
            case "last name":
                updatedUser.setLastName(newInfo);
                break;
        }

        try {
            userService.updateProfile(updatedUser);
            System.out.println(selection + " update successful");
        } catch (InvalidRequestException | AuthorizationException | ResourcePersistenceException e) {
            System.err.println(e.getMessage());
        }

    }

}
