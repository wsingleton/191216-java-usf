
package com.revature.app;

import com.revature.repo.BankAccountRepo;
import com.revature.repo.UserRepo;

public class MainMenu {

    final BankAccountRepo bankAccountRepo = new BankAccountRepo();
    final UserRepo userRepo = new UserRepo();

    public static void main(String[] args) {

        com.revature.screens.MainMenu.mainMenu();


    }

}