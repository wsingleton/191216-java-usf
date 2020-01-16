package com.bankboi.application;

import com.bankboi.repos.bankboirepo;
import com.bankboi.repos.userrepo;
import com.bankboi.screens.Main;;

class MainMenu {

    static bankboirepo bankAccountRepo = new bankboirepo();
    static userrepo userRepo = new userrepo();

    public static void main(String[] args) {

        Main.mainMenu();


    }

}