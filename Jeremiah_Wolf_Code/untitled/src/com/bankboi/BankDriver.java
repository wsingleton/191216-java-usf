package com.bankboi;

public class BankDriver {

    public static void main(String[] args) {
        BankBoi bankboi = new BankBoi();
        bankboi.readFile();
        bankboi.menu();
        bankboi.writeFile();
    }
}
