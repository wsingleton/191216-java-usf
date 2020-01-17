package com.revature.app;

import com.revature.repo.BankAccountRepo;
import com.revature.repo.UserRepo;
import com.revature.screens.MainMenuScreen;

public class MainMenu {

   final BankAccountRepo bankAccountRepo = new BankAccountRepo();
   final UserRepo userRepo = new UserRepo();

    public static void main(String[] args) {

        MainMenuScreen.mainMenu();


}

}