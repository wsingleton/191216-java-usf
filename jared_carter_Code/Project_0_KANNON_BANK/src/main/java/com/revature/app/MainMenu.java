package com.revature.app;

import com.revature.repo.BankAccountRepo;
import com.revature.repo.UserRepo;
import com.revature.screens.MainMenuScreen;

public class MainMenu {

    static BankAccountRepo bankAccountRepo = new BankAccountRepo();
    static UserRepo userRepo = new UserRepo();

    public static void main(String[] args) {

        MainMenuScreen.mainMenu();


}

}