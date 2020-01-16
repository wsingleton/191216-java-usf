package com.reavture;


import com.reavture.repos.*;
import com.reavture.screens.*;

public class NewWorldBankDriver {

    static BankRepo bankRepo = new BankRepo();
    static UserRepo userRepo = new UserRepo();


    public static void main(String[] args) {

        HomeScreen.home();

    }

}



